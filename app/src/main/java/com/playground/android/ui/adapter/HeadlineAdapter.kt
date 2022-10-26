package com.playground.android.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.playground.android.data.model.Headline
import com.playground.android.databinding.ItemHeadlineBinding
import com.playground.android.ui.adapter.dynamic.BaseDynamicAdapter
import com.playground.android.ui.adapter.dynamic.DynamicAdapterItem

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