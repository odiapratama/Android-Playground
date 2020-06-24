package com.problemsolver.androidplayground.utils

import android.widget.ImageView
import coil.api.load
import coil.transform.CircleCropTransformation

fun ImageView.loadCircleImage(url: String) {
    this.load(url) {
        crossfade(true)
        transformations(CircleCropTransformation())
    }
}