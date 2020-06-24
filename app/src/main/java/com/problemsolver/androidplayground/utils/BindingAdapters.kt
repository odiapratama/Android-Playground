package com.problemsolver.androidplayground.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("circleImage")
fun ImageView.circleImage(url: String) {
    this.loadCircleImage(url)
}