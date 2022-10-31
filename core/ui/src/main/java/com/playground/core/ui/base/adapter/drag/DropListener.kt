package com.playground.core.ui.base.adapter.drag

import android.view.DragEvent
import android.view.View

class DropListener(private val onDrop: () -> Unit) : View.OnDragListener {
    override fun onDrag(v: View?, event: DragEvent?): Boolean {
        when (event?.action) {
            DragEvent.ACTION_DROP -> onDrop()
        }
        return true
    }
}