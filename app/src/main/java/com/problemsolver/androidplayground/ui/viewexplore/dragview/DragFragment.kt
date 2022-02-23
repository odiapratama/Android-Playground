package com.problemsolver.androidplayground.ui.viewexplore.dragview

import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.databinding.FragmentDragBinding
import com.problemsolver.androidplayground.ui.adapter.drag.DragAdapter
import com.problemsolver.androidplayground.ui.adapter.drag.DropListener

class DragFragment : BaseFragment<FragmentDragBinding>() {

    private lateinit var orderAdapter: DragAdapter
    private lateinit var dragAdapter: DragAdapter
    private var selectedWord = ""
    private var selectedIndex = 0
    private val words = arrayListOf("Hello", "World", "Android", "Playground")

    override fun setLayout() = R.layout.fragment_drag

    override fun viewOnReady() {
        orderAdapter = DragAdapter(ArrayList()) { text, position ->
            selectedWord = text
            selectedIndex = position
        }
        dragAdapter = DragAdapter(words) { text, position ->
            selectedWord = text
            selectedIndex = position
        }
        dragAdapter.submitList(words)

        binding.rvOrder.adapter = orderAdapter
        binding.rvDrag.adapter = dragAdapter

        binding.rvOrder.setOnDragListener(
            DropListener {
                orderAdapter.addItem(selectedWord)
                dragAdapter.removeItem(selectedWord)
            }
        )

        binding.rvDrag.setOnDragListener(
            DropListener {
                dragAdapter.addItem(selectedWord)
                orderAdapter.removeItem(selectedWord)
            }
        )
    }
}