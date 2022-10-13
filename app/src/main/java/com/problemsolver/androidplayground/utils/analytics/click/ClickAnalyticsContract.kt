package com.problemsolver.androidplayground.utils.analytics.click

import android.view.View

interface ClickAnalyticsContract {
    fun registerClickAnalytics(view: View)
}