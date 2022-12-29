package com.playground.feature.main.di

import com.playground.feature.main.navigation.orbit.MainNavOrbit
import com.playground.feature.main.route.SplashNavPortalImpl
import com.playground.feature.splash.navigation.portal.SplashNavPortal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object SplashModule {

    @Provides
    fun createSplashNavPortal(mainNavOrbit: MainNavOrbit): SplashNavPortal {
        return SplashNavPortalImpl(mainNavOrbit)
    }
}