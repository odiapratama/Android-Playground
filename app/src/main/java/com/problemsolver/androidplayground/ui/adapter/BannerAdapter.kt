package com.problemsolver.androidplayground.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.problemsolver.androidplayground.data.model.Banner
import com.problemsolver.androidplayground.databinding.ItemBannerBinding
import com.problemsolver.androidplayground.ui.adapter.dynamic.BaseDynamicAdapter
import com.problemsolver.androidplayground.ui.adapter.dynamic.DynamicAdapterItem

class BannerAdapter : BaseDynamicAdapter<Banner, BannerAdapter.BannerViewHolder>(Banner::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return BannerViewHolder(
            ItemBannerBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun bindViewHolder(
        model: Banner,
        viewHolder: BannerViewHolder,
        payloads: List<DynamicAdapterItem.DataPayload>
    ) {
        viewHolder.bindItem(model)
    }

    inner class BannerViewHolder(
        private val binding: ItemBannerBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: Banner) {
            binding.dataItem = item
            binding.executePendingBindings()
        }
    }
}