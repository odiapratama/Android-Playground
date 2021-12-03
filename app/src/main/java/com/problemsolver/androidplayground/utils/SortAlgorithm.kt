package com.problemsolver.androidplayground.utils

import java.util.*

object SortAlgorithm {

    /**
     * TIME COMPLEXITY
     * Best : Ω(n)
     * Average : Θ(n^2)
     * Worst : O(n^2)
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

    /**
     * TIME COMPLEXITY
     * Best : Ω(n^2)
     * Average : Θ(n^2)
     * Worst : O(n^2)
     * */
    fun <T : Comparable<T>> selectionSort(array: List<T>, asc: Boolean = true) {
        for (i in 0..array.size - 2) {
            var pointer = i
            for (j in (i + 1) until array.size) {
                if (asc) {
                    if (array[pointer] > array [j]) {
                        pointer = j
                    }
                } else {
                    if (array[pointer] < array [j]) {
                        pointer = j
                    }
                }
            }

            if (asc) {
                if (array[pointer] < array[i]) {
                    Collections.swap(array, i, pointer)
                }
            } else {
                if (array[pointer] > array[i]) {
                    Collections.swap(array, i, pointer)
                }
            }
        }
    }
}
