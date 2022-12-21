package com.playground.feature.splash.navigation.space

import com.playground.core.ui.navigation.NavSpace
import com.playground.feature.splash.navigation.orbit.SplashNavOrbit
import com.playground.feature.splash.navigation.portal.SplashNavPortal
import com.playground.feature.splash.navigation.satellite.SplashNavSatellite

interface SplashNavSpace: NavSpace<SplashNavOrbit, SplashNavPortal, SplashNavSatellite> {
    fun toMenu()
}