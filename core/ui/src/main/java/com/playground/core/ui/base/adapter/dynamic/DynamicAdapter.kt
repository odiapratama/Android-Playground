package com.playground.core.ui.base.adapter.dynamic

import android.util.SparseArray
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class DynamicAdapter(
    private val delegates: SparseArray<BaseDynamicAdapter<DynamicAdapterItem, RecyclerView.ViewHolder>>
): ListAdapter<DynamicAdapterItem, RecyclerView.ViewHolder>(DynamicAdapterItemCallback()) {

    override fun getItemViewType(position: Int): Int {
        for (i in 0 until delegates.size()) {
            if (delegates[i].modelClass == getItem(position).javaClass) {
                return delegates.keyAt(i)
            }
        }
        throw NullPointerException("ViewType $position not found")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegates[viewType].createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindViewHolder(holder, position, mutableListOf())
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        val delegateAdapter = delegates[getItemViewType(position)]
        if (delegateAdapter != null) {
            val payload = payloads.map { it as DynamicAdapterItem.DataPayload }
            delegateAdapter.bindViewHolder(getItem(position), holder, payload)
        } else {
            throw NullPointerException("Adapter $position not found")
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        delegates[holder.itemViewType].onViewRecycled(holder)
        super.onViewRecycled(holder)
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        delegates[holder.itemViewType].onViewAttachedToWindow(holder)
        super.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        delegates[holder.itemViewType].onViewDetachedFromWindow(holder)
        super.onViewDetachedFromWindow(holder)
    }

    class Builder {
        private var count = 0
        private val delegates: SparseArray<BaseDynamicAdapter<DynamicAdapterItem, RecyclerView.ViewHolder>> = SparseArray()

        @Suppress("UNCHECKED_CAST")
        fun add(adapter: BaseDynamicAdapter<out DynamicAdapterItem, *>): Builder {
            delegates.put(count++, adapter as BaseDynamicAdapter<DynamicAdapterItem, RecyclerView.ViewHolder>)
            return this
        }

        fun build(): DynamicAdapter {
            require(count != 0) {"There is no adapter"}
            return DynamicAdapter(delegates)
        }
    }
}