package com.problemsolver.androidplayground.ui.threading

import androidx.navigation.fragment.findNavController
import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.databinding.FragmentThreadingBinding

class ThreadingFragment : BaseFragment<FragmentThreadingBinding>() {

    private val navController by lazy { findNavController() }

    override fun setLayout() = R.layout.fragment_threading

    override fun viewOnReady() {
        binding.btnRxJava.setOnClickListener {
            navController.navigate(
                ThreadingFragmentDirections.actionThreadingToRxJavaFragment()
            )
        }

        binding.btnCoroutines.setOnClickListener {
            navController.navigate(
                ThreadingFragmentDirections.actionThreadingToCoroutinesFragment()
            )
        }
    }
}