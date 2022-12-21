package com.playground.feature.main.navigation.space

import com.playground.core.ui.navigation.NavSpace
import com.playground.feature.main.navigation.orbit.MainNavOrbit
import com.playground.feature.main.navigation.portal.MainNavPortal
import com.playground.feature.main.navigation.satellite.MainNavSatellite

interface MainNavSpace : NavSpace<MainNavOrbit, MainNavPortal, MainNavSatellite>