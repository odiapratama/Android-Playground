package com.playground.core.ui.base.activity

import android.app.Activity
import android.view.View
import androidx.databinding.ViewDataBinding

class BaseViewBindingActivityImpl<V: ViewDataBinding>:
    BaseViewBindingActivity<V> {

    private var activityName: String = ""

    private lateinit var _binding: V
    override val binding: V
        get() = _binding

    override fun initBinding(binding: V, activity: Activity, onBound: (V.() -> Unit)?): View {
        _binding = binding
        activityName = activity::class.simpleName ?: "N/A"
        onBound?.invoke(binding)
        return binding.root
    }

    override fun requiredBinding(onBound: (V.() -> Unit)?) {
        return onBound?.invoke(binding) ?: throw IllegalStateException("Accessing binding outside of Activity lifecycle: $activityName")
    }
}