package com.playground.feature.splash.navigation.satellite

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext

class SplashNavSatelliteImpl(
    @ApplicationContext override val context: Context
) : SplashNavSatellite