package com.problemsolver.androidplayground.utils

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.problemsolver.androidplayground.utils.lazyview.LazyViewBinding

fun <T : Any> Fragment.lazyViewBinding(initializer: (View) -> T) = LazyViewBinding(this, initializer)

fun LifecycleOwner.getScreenName(): String {
    val ownerName = this.toString()
    if (ownerName.contains("Activity") || ownerName.contains("Fragment")) {
        return ownerName.substring(0, ownerName.indexOf("{"))
    }
    return ownerName
}