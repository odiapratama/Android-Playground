package com.playground.feature.more.navigation.orbit

import com.playground.core.ui.navigation.NavOrbit
import com.playground.feature.more.navigation.screen.MoreNavScreen

interface MoreNavOrbit : NavOrbit<MoreNavScreen> {
    fun toJetpack()
    fun toUiDrag()
    fun toThreading()
    fun toError()
}