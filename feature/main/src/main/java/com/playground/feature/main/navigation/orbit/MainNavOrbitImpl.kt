package com.playground.feature.main.navigation.orbit

import android.app.Activity
import com.playground.feature.main.R
import com.playground.feature.main.navigation.screen.MainNavScreen
import com.playground.feature.main.ui.ErrorFragmentDirections

class MainNavOrbitImpl(
    override val activity: Activity
) : MainNavOrbit {

    override fun navigateTo(screen: MainNavScreen) {
        startNavigation(R.navigation.nav_main, screen.fragmentId)
    }

    override fun toMenu() {
        nextNavigation(ErrorFragmentDirections.errorFragmentToMenuFragment())
    }
}