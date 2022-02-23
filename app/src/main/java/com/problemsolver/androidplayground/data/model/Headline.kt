package com.problemsolver.androidplayground.data.model

import com.problemsolver.androidplayground.ui.adapter.dynamic.DynamicAdapterItem

data class Headline(
    val title: String,
    val subtitle: String
): DynamicAdapterItem {
    override fun id() = title
    override fun content() = subtitle
}
