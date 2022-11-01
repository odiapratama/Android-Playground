package com.playground.feature.home.data.model

import com.playground.core.ui.base.adapter.dynamic.DynamicAdapterItem

data class Banner(
    val title: String,
    val subtitle: String,
    val description: String,
    val image: String
) : DynamicAdapterItem {
    override fun id() = title
    override fun content() = description
}
