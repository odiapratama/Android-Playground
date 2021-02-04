package com.problemsolver.androidplayground.ui.jetpack.motion

import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.databinding.FragmentMotionBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MotionFragment : BaseFragment<FragmentMotionBinding>() {

    override fun setLayout() = R.layout.fragment_motion

    override fun viewOnReady() {
        binding.motion.transitionToStart()
        GlobalScope.launch(Dispatchers.Main) {
            delay(3000)
            binding.motion.transitionToEnd()
        }
    }
}