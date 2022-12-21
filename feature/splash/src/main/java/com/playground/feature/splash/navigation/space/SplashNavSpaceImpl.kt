package com.playground.feature.splash.navigation.space

import com.playground.feature.splash.navigation.orbit.SplashNavOrbit
import com.playground.feature.splash.navigation.portal.SplashNavPortal
import com.playground.feature.splash.navigation.satellite.SplashNavSatellite

class SplashNavSpaceImpl(
    override val orbit: SplashNavOrbit,
    override val portal: SplashNavPortal,
    override val satellite: SplashNavSatellite
) : SplashNavSpace {

    override fun toMenu() {
        orbit.toOnBoard()
    }
}