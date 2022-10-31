package com.playground.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.playground.core.ui.base.adapter.BaseDynamicAdapter
import com.playground.core.ui.base.adapter.DynamicAdapterItem
import com.playground.feature.home.databinding.ItemBannerBinding
import com.playground.home.data.model.Banner

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
    ) : RecyclerView.ViewHolder(binding.root) {
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