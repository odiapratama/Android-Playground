package com.playground.explore.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import com.playground.core.ui.base.adapter.drag.ReorderAdapter
import com.playground.core.ui.base.adapter.drag.ReorderCallback
import com.playground.core.ui.ext.lazyViewBinding
import com.playground.feature.explore.R
import com.playground.feature.explore.databinding.FragmentExploreBinding

class ExploreFragment : Fragment(R.layout.fragment_explore) {

    private val binding by lazyViewBinding(FragmentExploreBinding::bind)
    private lateinit var reorderAdapter: ReorderAdapter
    private lateinit var touchHelper: ItemTouchHelper

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        reorderAdapter = ReorderAdapter(ArrayList(), {
            touchHelper.startDrag(it)
        }, {

        })
        binding.rvReorder.adapter = reorderAdapter
        val reorderCallback = ReorderCallback(reorderAdapter)
        touchHelper = ItemTouchHelper(reorderCallback)
        touchHelper.attachToRecyclerView(binding.rvReorder)

        binding.fabAdd.setOnClickListener {
            reorderAdapter.addData(reorderAdapter.itemCount.toString())
        }
    }
}