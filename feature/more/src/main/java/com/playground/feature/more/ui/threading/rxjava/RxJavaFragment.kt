package com.playground.feature.more.ui.threading.rxjava

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.playground.core.ui.ext.observe
import com.playground.feature.more.R

class RxJavaFragment : Fragment(R.layout.rx_java_fragment) {

    private val viewModel by viewModels<RxJavaViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        viewModel.rxCreate()
        viewModel.rxDefer()
        viewModel.rxBuffer()
        viewModel.rxMap()
        viewModel.rxFlatMap()
        viewModel.rxSwitchMap()
        viewModel.rxConcatMap()
        viewModel.rxGroupBy()
        viewModel.rxScan()
        viewModel.rxCombinedLatest()
        viewModel.rxJoin()
        viewModel.rxMerge()
        viewModel.rxConcat()
        viewModel.rxZip()

        observe(viewModel.threadingState) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }
}