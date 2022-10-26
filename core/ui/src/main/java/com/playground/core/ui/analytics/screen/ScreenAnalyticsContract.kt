package com.playground.core.ui.analytics.screen

import androidx.lifecycle.LifecycleOwner

interface ScreenAnalyticsContract {
    fun registerLifecycleOwner(lifecycleOwner: LifecycleOwner)
}