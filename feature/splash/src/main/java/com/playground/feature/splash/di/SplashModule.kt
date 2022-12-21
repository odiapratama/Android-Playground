package com.playground.feature.splash.di

import android.app.Activity
import com.playground.feature.splash.navigation.orbit.SplashNavOrbit
import com.playground.feature.splash.navigation.orbit.SplashNavOrbitImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object SplashModule {

    @Provides
    fun createSplashNavOrbit(activity: Activity): SplashNavOrbit {
        return SplashNavOrbitImpl(activity)
    }
}