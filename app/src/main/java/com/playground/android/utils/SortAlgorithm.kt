package com.playground.android.utils

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
                    if (array[pointer] > array[j]) {
                        pointer = j
                    }
                } else {
                    if (array[pointer] < array[j]) {
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

    /**
     * TIME COMPLEXITY
     * Best : Ω(n log(n))
     * Average : Θ(n log(n))
     * Worst : O(n^2)
     * */
    fun <T : Comparable<T>> quickSort(array: List<T>, l: Int, r: Int) {
        if (l < r) {
            val p = partition(array, l, r)
            quickSort(array, l, p - 1)
            quickSort(array, p, r)
        }
    }

    private fun <T : Comparable<T>> partition(array: List<T>, l: Int, r: Int): Int {
        var left = l
        var right = r
        val mid = (left + right) / 2
        val pivot = array[mid]

        while (left <= right) {
            while (array[left] < pivot) {
                left++
            }

            while (array[right] > pivot) {
                right--
            }

            if (left <= right) {
                Collections.swap(array, left, right)
                left++
                right--
            }
        }

        return left
    }

    /**
     * TIME COMPLEXITY
     * Best : Ω(n log(n))
     * Average : Θ(n log(n))
     * Worst : O(n log(n))
     * */
    fun <T : Comparable<T>> mergeSort(array: Array<T>, l: Int, r: Int) {
        if (l >= r) return
        val mid = (l + r) / 2
        val temp = arrayOfNulls<Comparable<T>>(array.size)

        mergeSort(array, l, mid)
        mergeSort(array, mid + 1, r)
        mergeHalves(array, temp, l, r)
    }

    private fun <T : Comparable<T>> mergeHalves(
        array: Array<T>,
        temp: Array<Comparable<T>?>,
        leftStart: Int,
        rightEnd: Int
    ) {
        val leftEnd = (leftStart + rightEnd) / 2
        val rightStart = leftEnd + 1
        val size = rightEnd - leftStart + 1

        var left = leftStart
        var index = leftStart
        var right = rightStart

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] < array[right]) {
                temp[index] = array[left]
                left++
            } else {
                temp[index] = array[right]
                right++
            }

            index++
        }

        System.arraycopy(array, left, temp, index, leftEnd - left + 1)
        System.arraycopy(array, right, temp, index, rightEnd - right + 1)
        System.arraycopy(temp, leftStart, array, leftStart, size)
    }
}
