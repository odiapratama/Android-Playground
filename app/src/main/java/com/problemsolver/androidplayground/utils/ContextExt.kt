package com.problemsolver.androidplayground.utils

import android.view.View
import androidx.fragment.app.Fragment
import com.problemsolver.androidplayground.utils.lazyview.LazyViewBinding

fun <T : Any> Fragment.lazyViewBinding(initializer: (View) -> T) = LazyViewBinding(this, initializer)