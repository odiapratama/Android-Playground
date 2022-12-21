package com.playground.core.ui.navigation

import android.app.Activity
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import com.playground.core.ui.R

interface NavOrbit<S : NavScreen> : NavContract {

    val activity: Activity

    override val controller: NavController?
        get() = ((activity as FragmentActivity).supportFragmentManager.findFragmentById(R.id.navOrbit) as NavHostFragment).navController

    override fun navigateUp() {
        controller?.navigateUp()
    }

    fun startNavigation(@NavigationRes navId: Int, @IdRes fragmentId: Int, bundle: Bundle? = null) {
        controller?.apply {
            navInflater.inflate(navId).apply {
                setStartDestination(fragmentId)
                setGraph(this, bundle)
            }
        }
    }

    fun nextNavigation(@IdRes navId: Int) {
        controller?.navigate(navId)
    }

    fun nextNavigation(navId: NavDirections) {
        controller?.navigate(navId)
    }
}