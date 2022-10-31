package com.playground.core.ui.base.adapter.drag

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import androidx.core.view.MotionEventCompat
import androidx.recyclerview.widget.RecyclerView
import com.playground.core.ui.databinding.ItemIconDragBinding
import java.util.*

class ReorderAdapter(
    private var items: ArrayList<String>,
    private val onDrag: (RecyclerView.ViewHolder) -> Unit,
    private val onSwipe: () -> Unit
) : RecyclerView.Adapter<ReorderAdapter.ReorderViewHolder>(), ItemTouchHelperAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReorderViewHolder {
        return ReorderViewHolder(
            ItemIconDragBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ReorderViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount() = items.size

    inner class ReorderViewHolder(
        val binding: ItemIconDragBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("ClickableViewAccessibility")
        fun onBind(data: String) {
            binding.item = data
            binding.executePendingBindings()
            binding.ivDrag.setOnTouchListener { _, event ->
                @Suppress("DEPRECATION")
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    onDrag(this@ReorderViewHolder)
                }
                false
            }
        }
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        Collections.swap(items, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onItemDismiss(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
        onSwipe()
    }

    fun addData(data: String) {
        items.add(data)
        notifyItemInserted(items.size - 1)
    }
}