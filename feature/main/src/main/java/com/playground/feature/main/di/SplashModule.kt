package com.playground.feature.main.di

import android.content.Context
import com.playground.feature.main.navigation.orbit.MainNavOrbit
import com.playground.feature.main.route.SplashNavPortalImpl
import com.playground.feature.splash.navigation.orbit.SplashNavOrbit
import com.playground.feature.splash.navigation.portal.SplashNavPortal
import com.playground.feature.splash.navigation.satellite.SplashNavSatellite
import com.playground.feature.splash.navigation.satellite.SplashNavSatelliteImpl
import com.playground.feature.splash.navigation.space.SplashNavSpace
import com.playground.feature.splash.navigation.space.SplashNavSpaceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityComponent::class)
object SplashModule {

    @Provides
    fun createSplashNavPortal(mainNavOrbit: MainNavOrbit): SplashNavPortal {
        return SplashNavPortalImpl(mainNavOrbit)
    }

    @Provides
    fun createSplashNavSatellite(@ApplicationContext context: Context): SplashNavSatellite {
        return SplashNavSatelliteImpl(context)
    }

    @Provides
    fun createSplashNavSpace(
        orbit: SplashNavOrbit,
        portal: SplashNavPortal,
        satellite: SplashNavSatellite
    ): SplashNavSpace {
        return SplashNavSpaceImpl(orbit, portal, satellite)
    }
}