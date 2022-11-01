package com.playground.feature.more.ui.jetpack.motion

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.playground.core.ui.ext.lazyViewBinding
import com.playground.feature.more.R
import com.playground.feature.more.databinding.FragmentMotionBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MotionFragment : Fragment(R.layout.fragment_motion) {

    private val binding by lazyViewBinding(FragmentMotionBinding::bind)
    private lateinit var viewModel: MotionViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MotionViewModel::class.java]
        initView()
    }

    private fun initView() {
        binding.motion.transitionToStart()
        lifecycleScope.launch(Dispatchers.Main) {
            delay(3000)
            binding.motion.transitionToEnd()
        }
    }
}