package com.playground.android.data.model

import com.playground.android.ui.adapter.dynamic.DynamicAdapterItem

data class Headline(
    val title: String,
    val subtitle: String
): DynamicAdapterItem {
    override fun id() = title
    override fun content() = subtitle
}
