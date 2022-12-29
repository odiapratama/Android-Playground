package com.playground.feature.splash.di

import androidx.fragment.app.Fragment
import com.playground.feature.splash.navigation.orbit.SplashNavOrbit
import com.playground.feature.splash.navigation.orbit.SplashNavOrbitImpl
import com.playground.feature.splash.navigation.portal.SplashNavPortal
import com.playground.feature.splash.navigation.satellite.SplashNavSatellite
import com.playground.feature.splash.navigation.satellite.SplashNavSatelliteImpl
import com.playground.feature.splash.navigation.space.SplashNavSpace
import com.playground.feature.splash.navigation.space.SplashNavSpaceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object SplashModule {

    @Provides
    fun createSplashNavOrbit(fragment: Fragment): SplashNavOrbit {
        return SplashNavOrbitImpl(fragment = fragment)
    }

    @Provides
    fun createSplashNavSatellite(fragment: Fragment): SplashNavSatellite {
        return SplashNavSatelliteImpl(fragment = fragment)
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