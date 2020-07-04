package com.problemsolver.androidplayground.utils

import android.view.View
import android.widget.ImageView
import coil.api.load
import coil.transform.CircleCropTransformation

fun View.toVisible() {
    visibility = View.VISIBLE
}

fun View.toGone() {
    visibility = View.GONE
}

fun ImageView.loadCircleImage(url: String) {
    this.load(url) {
        crossfade(true)
        transformations(CircleCropTransformation())
    }
}