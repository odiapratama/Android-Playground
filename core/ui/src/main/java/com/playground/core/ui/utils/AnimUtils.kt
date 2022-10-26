package com.playground.core.ui.utils

import android.util.Pair
import android.view.View

object AnimUtils {
    fun getClickOrigin(anchor: View?, contentView: View): Pair<Int, Int> {
        if (anchor == null) return Pair(0, 0)

        val anchorCoordinates = IntArray(2)
        anchor.getLocationOnScreen(anchorCoordinates)
        anchorCoordinates[0] += anchor.width / 2
        anchorCoordinates[1] += anchor.height / 2

        val contentCoordinates = IntArray(2)
        contentView.getLocationOnScreen(contentCoordinates)

        val x = anchorCoordinates[0] - contentCoordinates[0]
        val y = anchorCoordinates[1] - contentCoordinates[1]

        return Pair(x, y)
    }
}