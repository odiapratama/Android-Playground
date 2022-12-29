package com.playground.feature.main.di

import android.app.Activity
import com.playground.feature.main.navigation.orbit.MainNavOrbit
import com.playground.feature.main.navigation.orbit.MainNavOrbitImpl
import com.playground.feature.main.navigation.portal.MainNavPortal
import com.playground.feature.main.navigation.portal.MainNavPortalImpl
import com.playground.feature.main.navigation.satellite.MainNavSatellite
import com.playground.feature.main.navigation.satellite.MainNavSatelliteImpl
import com.playground.feature.main.navigation.space.MainNavSpace
import com.playground.feature.main.navigation.space.MainNavSpaceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object MainModule {

    @Provides
    fun createMainNavOrbit(activity: Activity): MainNavOrbit {
        return MainNavOrbitImpl(activity = activity)
    }

    @Provides
    fun createMainNavSatellite(activity: Activity): MainNavSatellite {
        return MainNavSatelliteImpl(activity = activity)
    }

    @Provides
    fun createMainNavPortal(mainNavOrbit: MainNavOrbit): MainNavPortal {
        return MainNavPortalImpl(mainNavOrbit)
    }

    @Provides
    fun createMainNavSpace(
        orbit: MainNavOrbit,
        portal: MainNavPortal,
        satellite: MainNavSatellite
    ): MainNavSpace {
        return MainNavSpaceImpl(orbit, portal, satellite)
    }
}