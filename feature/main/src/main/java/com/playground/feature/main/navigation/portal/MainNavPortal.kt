package com.playground.feature.main.navigation.portal

import com.playground.core.ui.navigation.NavPortal

interface MainNavPortal : NavPortal {
    fun toMenu()
    fun toSplash()
    fun toError()
}