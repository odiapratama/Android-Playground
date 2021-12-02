package com.problemsolver.androidplayground.ui.threading.rxjava

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.databinding.RxJavaFragmentBinding
import com.problemsolver.androidplayground.utils.observe

class RxJavaFragment : BaseFragment<RxJavaFragmentBinding>() {

    private val viewModel by viewModels<RxJavaViewModel>()

    override fun setLayout() = R.layout.rx_java_fragment

    override fun viewOnReady() {
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