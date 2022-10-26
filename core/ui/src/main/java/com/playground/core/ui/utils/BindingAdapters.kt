package com.playground.core.ui.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.playground.core.ui.ext.loadCircleImage

@BindingAdapter("circleImage")
fun ImageView.circleImage(url: String) {
    this.loadCircleImage(url)
}