package com.playground.core.ui.base.adapter.dynamic

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class DynamicAdapterItemCallback : DiffUtil.ItemCallback<DynamicAdapterItem>() {

    override fun areItemsTheSame(
        oldItem: DynamicAdapterItem,
        newItem: DynamicAdapterItem
    ) = oldItem::class == newItem::class && oldItem.id() == newItem.id()

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: DynamicAdapterItem,
        newItem: DynamicAdapterItem
    ) = oldItem.content() == newItem.content()

    override fun getChangePayload(oldItem: DynamicAdapterItem, newItem: DynamicAdapterItem) =
        oldItem.payload(newItem)
}