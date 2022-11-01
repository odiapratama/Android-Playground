package com.playground.feature.more.ui.threading

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.playground.core.ui.ext.lazyViewBinding
import com.playground.feature.more.R
import com.playground.feature.more.databinding.FragmentThreadingBinding

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