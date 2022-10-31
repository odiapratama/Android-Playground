package com.playground.home.data.model

import com.playground.core.ui.base.adapter.DynamicAdapterItem

data class Banner(
    val title: String,
    val subtitle: String,
    val description: String,
    val image: String
) : DynamicAdapterItem {
    override fun id() = title
    override fun content() = description
}
