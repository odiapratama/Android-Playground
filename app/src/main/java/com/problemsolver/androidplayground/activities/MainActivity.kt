package com.problemsolver.androidplayground.activities

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.activity.BaseActivity
import com.problemsolver.androidplayground.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayout() =
        R.layout.activity_main

    override fun viewOnReady() {
        setUpNavigation()
    }

    private fun setUpNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bnvMain, navHostFragment.navController)
    }
}
