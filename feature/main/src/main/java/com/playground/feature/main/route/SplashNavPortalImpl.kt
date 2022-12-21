package com.playground.feature.main.route

import com.playground.feature.main.navigation.orbit.MainNavOrbit
import com.playground.feature.splash.SplashFragmentDirections
import com.playground.feature.splash.navigation.portal.SplashNavPortal

class SplashNavPortalImpl(
    private val mainNavOrbit: MainNavOrbit
) : SplashNavPortal {

    override fun toMenu() {
        mainNavOrbit.nextNavigation(SplashFragmentDirections.splashFragmentToMenuFragment())
    }
}