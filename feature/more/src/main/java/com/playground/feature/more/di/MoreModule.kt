package com.playground.feature.more.di

import androidx.fragment.app.Fragment
import com.playground.feature.more.navigation.orbit.MoreNavOrbit
import com.playground.feature.more.navigation.orbit.MoreNavOrbitImpl
import com.playground.feature.more.navigation.portal.MoreNavPortal
import com.playground.feature.more.navigation.portal.MoreNavPortalImpl
import com.playground.feature.more.navigation.satellite.MoreNavSatellite
import com.playground.feature.more.navigation.satellite.MoreNavSatelliteImpl
import com.playground.feature.more.navigation.space.MoreNavSpace
import com.playground.feature.more.navigation.space.MoreNavSpaceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object MoreModule {

    @Provides
    fun createMoreNavOrbit(fragment: Fragment): MoreNavOrbit {
        return MoreNavOrbitImpl(fragment = fragment)
    }

    @Provides
    fun createMoreNavPortal(): MoreNavPortal {
        return MoreNavPortalImpl()
    }

    @Provides
    fun createMoreNavSatellite(fragment: Fragment): MoreNavSatellite {
        return MoreNavSatelliteImpl(fragment = fragment)
    }

    @Provides
    fun createMoreNavSpace(
        orbit: MoreNavOrbit,
        portal: MoreNavPortal,
        satellite: MoreNavSatellite
    ): MoreNavSpace {
        return MoreNavSpaceImpl(orbit, portal, satellite)
    }
}