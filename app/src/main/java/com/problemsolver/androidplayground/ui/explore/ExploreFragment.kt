package com.problemsolver.androidplayground.ui.explore

import androidx.recyclerview.widget.ItemTouchHelper
import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.databinding.ExploreFragmentBinding
import com.problemsolver.androidplayground.ui.adapter.drag.ReorderAdapter
import com.problemsolver.androidplayground.ui.adapter.drag.ReorderCallback

class ExploreFragment : BaseFragment<ExploreFragmentBinding>() {

    private lateinit var reorderAdapter: ReorderAdapter
    private lateinit var touchHelper: ItemTouchHelper


    override fun setLayout() = R.layout.explore_fragment

    override fun viewOnReady() {
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