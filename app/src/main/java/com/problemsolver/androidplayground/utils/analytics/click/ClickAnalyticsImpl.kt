package com.problemsolver.androidplayground.utils.analytics.click

import android.view.View

class ClickAnalyticsImpl: ClickAnalyticsContract {
    override fun registerClickAnalytics(view: View) {
        if (view.tag.toString().isEmpty()) {
            throw RuntimeException("Assign tag to asset ${view.id}")
        }
        // add tracking function (view.tag)
    }
}