package com.playground.android.ui.jetpack.motion

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.playground.android.R
import com.playground.android.databinding.FragmentMotionBinding
import com.playground.core.ui.ext.lazyViewBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MotionFragment : Fragment(R.layout.fragment_motion) {

    private val binding by lazyViewBinding(FragmentMotionBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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