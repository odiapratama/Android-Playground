package com.playground.core.ui.analytics.click

import android.view.View

interface ClickAnalyticsContract {
    fun registerClickAnalytics(view: View)
}