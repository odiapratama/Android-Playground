package com.playground.android.ui.threading

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.playground.android.R
import com.playground.android.databinding.FragmentThreadingBinding
import com.playground.core.ui.ext.lazyViewBinding

class ThreadingFragment : Fragment(R.layout.fragment_threading) {

    private val binding by lazyViewBinding(FragmentThreadingBinding::bind)
    private val navController by lazy { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
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