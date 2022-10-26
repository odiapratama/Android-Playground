package com.playground.android.ui.explore

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import com.playground.android.R
import com.playground.android.databinding.ExploreFragmentBinding
import com.playground.android.ui.adapter.drag.ReorderAdapter
import com.playground.android.ui.adapter.drag.ReorderCallback
import com.playground.core.ui.ext.lazyViewBinding

class ExploreFragment : Fragment(R.layout.explore_fragment) {

    private val binding by lazyViewBinding(ExploreFragmentBinding::bind)
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