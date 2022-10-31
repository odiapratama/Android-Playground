package com.playground.android.ui.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.playground.android.R
import com.playground.android.databinding.FragmentMenuBinding
import com.playground.core.ui.ext.hideView
import com.playground.core.ui.ext.lazyViewBinding
import com.playground.core.ui.ext.showView

class MenuFragment : Fragment(R.layout.fragment_menu) {

    private val binding by lazyViewBinding(FragmentMenuBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.nav_host_main_menu) as NavHostFragment
        binding.bnvMain.onItemSelected = {
            when (it) {
                0 -> navHostFragment.navController.navigate(R.id.nav_home)
                1 -> navHostFragment.navController.navigate(R.id.nav_explore)
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