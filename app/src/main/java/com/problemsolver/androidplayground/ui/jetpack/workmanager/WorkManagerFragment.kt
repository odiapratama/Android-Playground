package com.problemsolver.androidplayground.ui.jetpack.workmanager

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toUri
import androidx.lifecycle.ViewModelProvider
import androidx.work.*
import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.data.model.FileDownload
import com.problemsolver.androidplayground.databinding.WorkManagerFragmentBinding
import com.problemsolver.androidplayground.utils.FileDownloadWorker
import com.problemsolver.androidplayground.utils.toGone
import com.problemsolver.androidplayground.utils.toVisible

class WorkManagerFragment : BaseFragment<WorkManagerFragmentBinding>() {

    private lateinit var permissions: ActivityResultLauncher<Array<String>>
    private lateinit var viewModel: WorkManagerViewModel
    private lateinit var workManager: WorkManager

    override fun setLayout() = R.layout.work_manager_fragment

    override fun viewOnReady() {
        viewModel = ViewModelProvider(this).get(WorkManagerViewModel::class.java)
        workManager = WorkManager.getInstance(requireContext())

        permissions = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {

            var isGranted = false
            it.forEach { item ->
                isGranted = item.value
            }

            if (!isGranted) {
                Toast.makeText(
                    requireContext(), getString(R.string.permission_not_granted), Toast.LENGTH_SHORT
                ).show()
            }
        }

        permissions.launch(
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        )

        val fileDownload = FileDownload(
            id = "192401",
            name = "PDF file download",
            type = "PDF",
            url = "https://www.learningcontainer.com/wp-content/uploads/2019/09/sample-pdf-download-10-mb.pdf",
            downloadedUri = null
        )

        binding.tvTitle.text = fileDownload.name
        binding.tvAction.text = getString(R.string.tap_to_download_file)

        binding.cvDownload.setOnClickListener {
            if (fileDownload.downloadedUri.isNullOrEmpty()) {
                startDownloadFile(
                    fileDownload,
                    success = {
                        binding.pbDownload.toGone()
                        fileDownload.downloadedUri = it
                        binding.tvAction.text = getString(R.string.tap_to_open_file)
                    },
                    failed = {
                        binding.pbDownload.toGone()
                        fileDownload.downloadedUri = null
                        binding.tvAction.text = getString(R.string.tap_to_download_file)
                        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                    },
                    running = {
                        binding.pbDownload.toVisible()
                        binding.tvAction.text = getString(R.string.downloading_file)
                    })
            } else {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setDataAndType(fileDownload.downloadedUri?.toUri(), "application/pdf")
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                try {
                    startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(
                        requireContext(), getString(R.string.cant_open_file), Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun startDownloadFile(
        file: FileDownload,
        success: (String) -> Unit,
        failed: (String) -> Unit,
        running: () -> Unit
    ) {
        val data = Data.Builder()

        data.apply {
            putString(FileDownloadWorker.FileParams.KEY_FILE_NAME, file.name)
            putString(FileDownloadWorker.FileParams.KEY_FILE_URL, file.url)
            putString(FileDownloadWorker.FileParams.KEY_FILE_TYPE, file.type)
        }

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresStorageNotLow(true)
            .setRequiresBatteryNotLow(true)
            .build()

        val worker = OneTimeWorkRequestBuilder<FileDownloadWorker>()
            .setConstraints(constraints)
            .setInputData(data.build())
            .build()

        workManager.enqueueUniqueWork(
            "worker-download:${System.currentTimeMillis()}",
            ExistingWorkPolicy.KEEP,
            worker
        )

        workManager.getWorkInfoByIdLiveData(worker.id).observe(viewLifecycleOwner) { info ->
            info?.let {
                when (it.state) {
                    WorkInfo.State.SUCCEEDED -> success(
                        it.outputData.getString(FileDownloadWorker.FileParams.KEY_FILE_URI) ?: ""
                    )
                    WorkInfo.State.FAILED -> failed(getString(R.string.download_failed))
                    WorkInfo.State.RUNNING -> running()
                    else -> failed(getString(R.string.something_went_wrong))
                }
            }
        }
    }
}