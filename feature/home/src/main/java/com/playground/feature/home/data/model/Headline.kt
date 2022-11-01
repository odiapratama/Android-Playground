package com.playground.feature.home.data.model

import com.playground.core.ui.base.adapter.dynamic.DynamicAdapterItem

data class Headline(
    val title: String,
    val subtitle: String
) : DynamicAdapterItem {
    override fun id() = title
    override fun content() = subtitle
}
