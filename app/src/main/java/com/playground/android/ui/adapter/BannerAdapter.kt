package com.playground.android.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.playground.android.data.model.Banner
import com.playground.android.databinding.ItemBannerBinding
import com.playground.android.ui.adapter.dynamic.BaseDynamicAdapter
import com.playground.android.ui.adapter.dynamic.DynamicAdapterItem

class BannerAdapter(
    private val onClick: (Banner) -> Unit
) : BaseDynamicAdapter<Banner, BannerAdapter.BannerViewHolder>(Banner::class.java) {

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
            with(binding) {
                dataItem = item
                clParent.setOnClickListener {
                    onClick(item)
                }
                executePendingBindings()
            }
        }
    }
}