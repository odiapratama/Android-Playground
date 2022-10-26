package com.playground.core.ui.base.activity

import android.app.Activity
import android.view.View
import androidx.databinding.ViewDataBinding

interface BaseViewBindingActivity<V: ViewDataBinding> {
    val binding: V
    fun initBinding(binding: V, activity: Activity, onBound: (V.() -> Unit)? = {}): View
    fun requiredBinding(onBound: (V.() -> Unit)? = {})
}