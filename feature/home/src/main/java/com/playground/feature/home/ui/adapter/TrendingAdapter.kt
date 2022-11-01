package com.playground.feature.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.playground.feature.home.databinding.ItemTrendingLayoutBinding
import com.playground.feature.home.data.model.TrendingItem
import com.playground.feature.home.utils.DiffCallback

class TrendingAdapter(
    private val itemClickListener: (TrendingItem) -> Unit = {}
) : ListAdapter<TrendingItem, TrendingAdapter.VH>(DiffCallback.get()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        return VH(ItemTrendingLayoutBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    inner class VH(private val binding: ItemTrendingLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TrendingItem) {
            with(binding) {
                item = data
                executePendingBindings()
                clParent.setOnClickListener { itemClickListener(data) }
            }
        }
    }
}