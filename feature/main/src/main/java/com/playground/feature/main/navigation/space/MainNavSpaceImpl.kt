package com.playground.feature.main.navigation.space

import com.playground.feature.main.navigation.orbit.MainNavOrbit
import com.playground.feature.main.navigation.portal.MainNavPortal
import com.playground.feature.main.navigation.satellite.MainNavSatellite

class MainNavSpaceImpl(
    override val orbit: MainNavOrbit,
    override val portal: MainNavPortal,
    override val satellite: MainNavSatellite
) : MainNavSpace