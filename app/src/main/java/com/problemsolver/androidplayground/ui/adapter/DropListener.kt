package com.problemsolver.androidplayground.ui.adapter

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