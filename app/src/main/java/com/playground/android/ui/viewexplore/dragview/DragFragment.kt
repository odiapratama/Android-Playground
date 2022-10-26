package com.playground.android.ui.viewexplore.dragview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.playground.android.R
import com.playground.android.databinding.FragmentDragBinding
import com.playground.android.ui.adapter.drag.DragAdapter
import com.playground.android.ui.adapter.drag.DropListener
import com.playground.core.ui.ext.lazyViewBinding

class DragFragment : Fragment(R.layout.fragment_drag) {

    private val binding by lazyViewBinding(FragmentDragBinding::bind)
    private lateinit var orderAdapter: DragAdapter
    private lateinit var dragAdapter: DragAdapter
    private var selectedWord = ""
    private var selectedIndex = 0
    private val words = arrayListOf("Hello", "World", "Android", "Playground")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
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