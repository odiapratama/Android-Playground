package com.problemsolver.androidplayground.ui

import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.activity.BaseActivity
import com.problemsolver.androidplayground.databinding.ActivityMainBinding
import com.problemsolver.androidplayground.utils.toGone
import com.problemsolver.androidplayground.utils.toVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun setLayout() = R.layout.activity_main

    override fun viewOnReady() = Unit

    fun showLoading(show: Boolean) {
        if (show) {
            binding.pbLoading.playAnimation()
            binding.pbLoading.toVisible()
        } else {
            binding.pbLoading.toGone()
            binding.pbLoading.cancelAnimation()
        }
    }
}
