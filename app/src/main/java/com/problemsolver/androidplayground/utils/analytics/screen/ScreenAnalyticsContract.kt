package com.problemsolver.androidplayground.utils.analytics.screen

import androidx.lifecycle.LifecycleOwner

interface ScreenAnalyticsContract {
    fun registerLifecycleOwner(lifecycleOwner: LifecycleOwner)
}