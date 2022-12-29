package com.playground.feature.more.navigation.space

import com.playground.feature.more.navigation.orbit.MoreNavOrbit
import com.playground.feature.more.navigation.portal.MoreNavPortal
import com.playground.feature.more.navigation.satellite.MoreNavSatellite

class MoreNavSpaceImpl(
    override val orbit: MoreNavOrbit,
    override val portal: MoreNavPortal,
    override val satellite: MoreNavSatellite
) : MoreNavSpace