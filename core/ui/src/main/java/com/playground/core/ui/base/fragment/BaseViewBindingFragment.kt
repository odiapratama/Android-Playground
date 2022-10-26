package com.playground.core.ui.base.fragment

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

interface BaseViewBindingFragment<V: ViewDataBinding> {
    val binding: V
    fun initBinding(binding: V, fragment: Fragment, onBound: (V.() -> Unit)? = {}): View
    fun requiredBinding(onBound: (V.() -> Unit)?)
    fun onDestroyViewBinding()
}