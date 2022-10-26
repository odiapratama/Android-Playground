package com.playground.core.ui.ext

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.playground.core.ui.lazyview.LazyViewBinding

fun <T : Any> Fragment.lazyViewBinding(initializer: (View) -> T) = LazyViewBinding(this, initializer)

fun LifecycleOwner.getScreenName(): String {
    val ownerName = this.toString()
    if (ownerName.contains("Activity") || ownerName.contains("Fragment")) {
        return ownerName.substring(0, ownerName.indexOf("{"))
    }
    return ownerName
}