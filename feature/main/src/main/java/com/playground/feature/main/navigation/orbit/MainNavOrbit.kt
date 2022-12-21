package com.playground.feature.main.navigation.orbit

import com.playground.core.ui.navigation.NavOrbit
import com.playground.feature.main.navigation.screen.MainNavScreen

interface MainNavOrbit: NavOrbit<MainNavScreen> {
    fun navigateTo(screen: MainNavScreen)
    fun toMenu()
}