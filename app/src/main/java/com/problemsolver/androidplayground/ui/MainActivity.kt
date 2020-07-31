package com.problemsolver.androidplayground.ui

import android.view.Menu
import androidx.navigation.fragment.NavHostFragment
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.let {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            menuInflater.inflate(R.menu.bottom_menu, menu)
            binding.bnvMain.setupWithNavController(menu, navHostFragment.navController)
        }
        return false
    }

    fun showLoading(show: Boolean) {
        if (show) binding.pbLoading.toVisible()
        else binding.pbLoading.toGone()
    }
}
