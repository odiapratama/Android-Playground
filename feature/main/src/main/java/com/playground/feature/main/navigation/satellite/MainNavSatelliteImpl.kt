package com.playground.feature.main.navigation.satellite

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext

class MainNavSatelliteImpl(
    @ApplicationContext override val context: Context
) : MainNavSatellite {

    override fun showError() {

    }
}