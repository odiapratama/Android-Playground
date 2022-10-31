package com.playground.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.playground.core.ui.base.adapter.dynamic.BaseDynamicAdapter
import com.playground.core.ui.base.adapter.dynamic.DynamicAdapterItem
import com.playground.feature.home.databinding.ItemHeadlineBinding
import com.playground.home.data.model.Headline

class HeadlineAdapter(
    private val onClick: (Headline) -> Unit
) : BaseDynamicAdapter<Headline, HeadlineAdapter.ViewHolder>(Headline::class.java) {

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ViewHolder(
            ItemHeadlineBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun bindViewHolder(
        model: Headline,
        viewHolder: ViewHolder,
        payloads: List<DynamicAdapterItem.DataPayload>
    ) {
        viewHolder.bindItem(model)
    }

    inner class ViewHolder(
        private val binding: ItemHeadlineBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindItem(item: Headline) {
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