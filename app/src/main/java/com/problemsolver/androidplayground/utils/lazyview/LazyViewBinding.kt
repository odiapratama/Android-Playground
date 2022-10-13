package com.problemsolver.androidplayground.utils.lazyview

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class LazyViewBinding<T : Any>(
    private val fragment: Fragment,
    private val initializer: (View) -> T
) : Lazy<T>, LifecycleEventObserver, LazyViewBindingContract<T?> {

    override var cached: T? = null

    override val value: T
        get() = cached ?: run {
            val init = initializer(fragment.requireView())
            cached = init
            fragment.viewLifecycleOwner.lifecycle.addObserver(this)
            init
        }

    override fun isInitialized() = cached != null

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            cached = null
        }
    }

    override fun toString() = cached.toString()
}