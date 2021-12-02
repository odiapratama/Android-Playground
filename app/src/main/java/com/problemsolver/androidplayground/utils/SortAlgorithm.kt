package com.problemsolver.androidplayground.utils

import java.util.*

object SortAlgorithm {

    /**
     * Time Complexity: O(n^2)
     * */
    fun <T : Comparable<T>> bubbleSort(array: List<T>, asc: Boolean = true) {
        val length = array.size - 1
        var count = 0

        if (asc) {
            while (count < length) {
                for (i in 0 until length) {
                    if (array[i] > array[i + 1]) {
                        Collections.swap(array, i, i + 1)
                        count = 0
                        break
                    } else {
                        count++
                    }
                }
            }
        } else {
            while (count < length) {
                for (i in 0 until length) {
                    if (array[i] < array[i + 1]) {
                        Collections.swap(array, i, i + 1)
                        count = 0
                        break
                    } else {
                        count++
                    }
                }
            }
        }
    }
}
