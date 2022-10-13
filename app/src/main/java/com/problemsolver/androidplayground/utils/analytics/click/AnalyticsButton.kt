package com.problemsolver.androidplayground.utils.analytics.click

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.button.MaterialButton

class AnalyticsButton(context: Context, attributeSet: AttributeSet) :
    MaterialButton(context, attributeSet),
    ClickAnalyticsContract by ClickAnalyticsImpl()
{
    override fun performClick(): Boolean {
        registerClickAnalytics(this)
        return super.performClick()
    }
}