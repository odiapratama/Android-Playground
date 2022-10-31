package com.playground.core.ui.base.adapter.dynamic

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseDynamicAdapter<M, in VH : RecyclerView.ViewHolder>(val modelClass: Class<out M>) {
    abstract fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
    abstract fun bindViewHolder(model: M, viewHolder: VH, payloads: List<DynamicAdapterItem.DataPayload>)
    open fun onViewRecycled(viewHolder: VH) = Unit
    open fun onViewDetachedFromWindow(viewHolder: VH) = Unit
    open fun onViewAttachedToWindow(viewHolder: VH) = Unit
}