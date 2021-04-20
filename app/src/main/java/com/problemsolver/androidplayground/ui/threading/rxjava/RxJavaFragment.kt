package com.problemsolver.androidplayground.ui.threading.rxjava

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.databinding.RxJavaFragmentBinding
import com.problemsolver.androidplayground.utils.observe

class RxJavaFragment : BaseFragment<RxJavaFragmentBinding>() {

    private lateinit var viewModel: RxJavaViewModel

    override fun setLayout() = R.layout.rx_java_fragment

    override fun viewOnReady() {
        viewModel = ViewModelProvider(this).get(RxJavaViewModel::class.java)

        viewModel.rxCreate()
        viewModel.rxDefer()
        viewModel.rxBuffer()
        viewModel.rxMap()
        viewModel.rxFlatMap()

        observe(viewModel.threadingState) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }
}