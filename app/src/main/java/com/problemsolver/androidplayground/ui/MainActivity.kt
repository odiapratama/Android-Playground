package com.problemsolver.androidplayground.ui

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.activity.BaseActivity
import com.problemsolver.androidplayground.databinding.ActivityMainBinding
import com.problemsolver.androidplayground.utils.toGone
import com.problemsolver.androidplayground.utils.toVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun setLayout() = R.layout.activity_main

    override fun viewOnReady() {
        setUpNavigation()
    }

    private fun setUpNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bnvMain, navHostFragment.navController)
    }

    fun showLoading(show: Boolean) {
        if (show) binding.pbLoading.toVisible()
        else binding.pbLoading.toGone()
    }
}
