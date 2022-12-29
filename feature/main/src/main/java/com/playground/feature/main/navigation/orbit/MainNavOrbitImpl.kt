package com.playground.feature.main.navigation.orbit

import android.app.Activity
import androidx.fragment.app.Fragment
import com.playground.feature.main.R
import com.playground.feature.main.navigation.screen.MainNavScreen
import com.playground.feature.main.ui.ErrorFragmentDirections

class MainNavOrbitImpl(
    override val activity: Activity? = null,
    override val fragment: Fragment? = null
) : MainNavOrbit {

    override fun navigateTo(screen: MainNavScreen) {
        startNavigation(R.navigation.nav_main, screen.fragmentId)
    }

    override fun toMenu() {
        nextNavigation(ErrorFragmentDirections.errorFragmentToMenuFragment())
    }
}