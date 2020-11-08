package com.problemsolver.androidplayground.ui.jetpack.datastore

import androidx.fragment.app.viewModels
import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.data.repository.LocalRepository
import com.problemsolver.androidplayground.databinding.FragmentDataStoreBinding
import com.problemsolver.androidplayground.utils.observe
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DataStoreFragment : BaseFragment<FragmentDataStoreBinding>() {

    @Inject
    lateinit var localRepository: LocalRepository
    private val dataStoreViewModel by viewModels<DataStoreViewModel>()

    override fun setLayout() = R.layout.fragment_data_store

    override fun viewOnReady() {
        with(binding) {
            btnSave.setOnClickListener {
                dataStoreViewModel.setDataText(etDataStore.text.toString())
            }
        }
    }

    override fun observeData() {
        observe(dataStoreViewModel.dataText) {
            binding.tvLastText.text = it
        }
    }
}