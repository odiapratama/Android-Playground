package com.problemsolver.androidplayground.ui.adapter

import android.content.ClipData
import android.os.Build
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.problemsolver.androidplayground.databinding.ItemSimpleBinding
import com.problemsolver.androidplayground.utils.toInvisible
import com.problemsolver.androidplayground.utils.toVisible

class DragAdapter(
    private val listItem: ArrayList<String>,
    private val listener: (String, Int) -> Unit
) : ListAdapter<String, DragAdapter.DragViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragViewHolder {
        return DragViewHolder(
            ItemSimpleBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: DragViewHolder, position: Int) {
        holder.bindTo(getItem(position), position)
    }

    inner class DragViewHolder(
        private val binding: ItemSimpleBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindTo(data: String, position: Int) {
            binding.item = data
            binding.executePendingBindings()

            binding.tvSimple.setOnLongClickListener {
                val clip = ClipData.newPlainText("", data)
                val builder = View.DragShadowBuilder(it)
                @Suppress("DEPRECATION")
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                    it.startDragAndDrop(clip, builder, it, 0)
                else
                    it.startDrag(clip, builder, it, 0)
                listener(data, position)
                true
            }

            binding.tvSimple.setOnDragListener(DragListener())
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    fun addItem(newItem: String) {
        listItem.add(newItem)
        submitList(listItem)
        notifyDataSetChanged()
    }

    fun removeItem(keyword: String) {
        listItem.remove(keyword)
        submitList(listItem)
        notifyDataSetChanged()
    }

    class DragListener : View.OnDragListener {
        override fun onDrag(v: View?, event: DragEvent?): Boolean {
            when (event?.action) {
                DragEvent.ACTION_DRAG_ENTERED -> v?.toInvisible()
                DragEvent.ACTION_DRAG_ENDED -> v?.toVisible()
            }
            return true
        }
    }
}