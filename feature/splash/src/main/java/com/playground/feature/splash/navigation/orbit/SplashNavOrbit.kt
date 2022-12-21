package com.playground.feature.splash.navigation.orbit

import com.playground.core.ui.navigation.NavOrbit
import com.playground.feature.splash.navigation.screen.SplashNavScreen

interface SplashNavOrbit : NavOrbit<SplashNavScreen> {
    fun toOnBoard()
}