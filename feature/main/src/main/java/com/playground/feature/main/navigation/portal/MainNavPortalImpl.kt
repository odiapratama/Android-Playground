package com.playground.feature.main.navigation.portal

import com.playground.feature.main.navigation.orbit.MainNavOrbit
import com.playground.feature.main.navigation.screen.MainNavScreen

class MainNavPortalImpl(
    private val mainNavOrbit: MainNavOrbit
) : MainNavPortal {

    override fun toMenu() {
        mainNavOrbit.navigateTo(MainNavScreen.Menu)
    }

    override fun toSplash() {
        mainNavOrbit.navigateTo(MainNavScreen.Menu)
    }

    override fun toError() {
        mainNavOrbit.navigateTo(MainNavScreen.Splash)
    }
}