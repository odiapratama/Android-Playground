package com.playground.home.data.model

import com.playground.core.ui.base.adapter.DynamicAdapterItem

data class Headline(
    val title: String,
    val subtitle: String
) : DynamicAdapterItem {
    override fun id() = title
    override fun content() = subtitle
}
