package com.problemsolver.androidplayground.data.model

import com.problemsolver.androidplayground.ui.adapter.dynamic.DynamicAdapterItem

data class Banner(
    val title: String,
    val subtitle: String,
    val description: String,
    val image: String
) : DynamicAdapterItem {
    override fun id() = title
    override fun content() = description
}
