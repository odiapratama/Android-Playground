package com.problemsolver.androidplayground.ui.jetpack

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.problemsolver.androidplayground.databinding.ItemJetpackBinding

class JetpackAdapter(
    private val listJetpack: List<String>,
    private val clickListener: (String) -> Unit
) : RecyclerView.Adapter<JetpackAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemJetpackBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount() = listJetpack.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(listJetpack[position])
    }

    inner class ViewHolder(
        private val binding: ItemJetpackBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindTo(data: String) {
            binding.item = data
            binding.executePendingBindings()
            binding.btnJetpack.setOnClickListener {
                clickListener(data)
            }
        }
    }
}