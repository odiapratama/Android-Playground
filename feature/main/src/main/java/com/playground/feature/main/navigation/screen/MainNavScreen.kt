package com.playground.feature.main.navigation.screen

import com.playground.core.ui.navigation.NavScreen
import com.playground.feature.main.R

enum class MainNavScreen(
    override val fragmentId: Int,
): NavScreen {
    Splash(R.id.splashFragment),
    Menu(R.id.menuFragment),
    Error(R.id.errorFragment)
}