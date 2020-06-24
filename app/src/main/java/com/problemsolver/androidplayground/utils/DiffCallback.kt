package com.problemsolver.androidplayground.utils

import androidx.recyclerview.widget.DiffUtil
import com.problemsolver.androidplayground.data.model.TrendingItem

object DiffCallback {
    fun get(): DiffUtil.ItemCallback<TrendingItem> {
        return object : DiffUtil.ItemCallback<TrendingItem>() {
            override fun areItemsTheSame(oldItem: TrendingItem, newItem: TrendingItem): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: TrendingItem, newItem: TrendingItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}