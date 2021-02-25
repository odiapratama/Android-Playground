package com.problemsolver.androidplayground.ui.menu

import androidx.navigation.fragment.NavHostFragment
import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.databinding.FragmentMenuBinding
import com.problemsolver.androidplayground.utils.hideView
import com.problemsolver.androidplayground.utils.showView

class MenuFragment : BaseFragment<FragmentMenuBinding>() {

    override fun setLayout() = R.layout.fragment_menu

    override fun viewOnReady() {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.nav_host_main_menu) as NavHostFragment
        binding.bnvMain.onItemSelected = {
            when (it) {
                0 -> navHostFragment.navController.navigate(R.id.home)
                1 -> navHostFragment.navController.navigate(R.id.explore)
                else -> navHostFragment.navController.navigate(R.id.more)
            }
        }
        navHostFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.home, R.id.explore, R.id.more -> binding.bnvMain.showView()
                else -> binding.bnvMain.hideView()
            }
        }
    }
}