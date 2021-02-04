package com.problemsolver.androidplayground.utils

import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import androidx.core.view.isGone
import androidx.core.view.isVisible
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

fun View.showView(duration: Long = 400) {
    if (isVisible) return
    toVisible()
    val animate = TranslateAnimation(0f, 0f, height.toFloat(), 0f)
    animate.duration = duration
    startAnimation(animate)
}

fun View.hideView(duration: Long = 400) {
    if (isGone) return
    toGone()
    val animate = TranslateAnimation(0f, 0f, 0f, height.toFloat())
    animate.duration = duration
    startAnimation(animate)
}