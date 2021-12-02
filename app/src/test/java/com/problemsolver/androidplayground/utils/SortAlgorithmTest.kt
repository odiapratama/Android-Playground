package com.problemsolver.androidplayground.utils

import com.problemsolver.androidplayground.utils.SortAlgorithm.bubbleSort
import org.junit.Assert.assertEquals
import org.junit.Test

class SortAlgorithmTest {

    @Test
    fun bubbleSortAscTest() {
        val actual = listOf(5, 1, 4, 2, 8)
        val expected = listOf(1, 2, 4, 5, 8)
        bubbleSort(actual)
        assertEquals(expected, actual)
    }

    @Test
    fun bubbleSortDscTest() {
        val actual = listOf(5, 1, 4, 2, 8)
        val expected = listOf(8, 5, 4, 2, 1)
        bubbleSort(actual, false)
        assertEquals(expected, actual)
    }
}