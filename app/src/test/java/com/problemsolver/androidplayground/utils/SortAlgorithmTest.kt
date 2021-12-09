package com.problemsolver.androidplayground.utils

import com.problemsolver.androidplayground.utils.SortAlgorithm.bubbleSort
import com.problemsolver.androidplayground.utils.SortAlgorithm.quickSort
import com.problemsolver.androidplayground.utils.SortAlgorithm.selectionSort
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

    @Test
    fun bubbleSortAscTest2() {
        val actual = listOf("A", "C", "D", "E", "B")
        val expected = listOf("A", "B", "C", "D", "E")
        bubbleSort(actual)
        assertEquals(expected, actual)
    }

    @Test
    fun bubbleSortDscTest2() {
        val actual = listOf("A", "C", "D", "E", "B")
        val expected = listOf("E", "D", "C", "B", "A")
        bubbleSort(actual, false)
        assertEquals(expected, actual)
    }

    @Test
    fun selectionSortAscTest() {
        val actual = listOf(5, 1, 4, 2, 8)
        val expected = listOf(1, 2, 4, 5, 8)
        selectionSort(actual)
        assertEquals(expected, actual)
    }

    @Test
    fun selectionSortDscTest() {
        val actual = listOf(5, 1, 4, 2, 8)
        val expected = listOf(8, 5, 4, 2, 1)
        selectionSort(actual, false)
        assertEquals(expected, actual)
    }

    @Test
    fun selectionSortAscTest2() {
        val actual = listOf("A", "C", "D", "E", "B")
        val expected = listOf("A", "B", "C", "D", "E")
        selectionSort(actual)
        assertEquals(expected, actual)
    }

    @Test
    fun selectionSortDscTest2() {
        val actual = listOf("A", "C", "D", "E", "B")
        val expected = listOf("E", "D", "C", "B", "A")
        selectionSort(actual, false)
        assertEquals(expected, actual)
    }

    @Test
    fun quickSortAscTest() {
        val actual = listOf(5, 1, 4, 2, 8)
        val expected = listOf(1, 2, 4, 5, 8)
        quickSort(actual, 0, actual.size - 1)
        assertEquals(expected, actual)
    }

    @Test
    fun quickSortAscTest2() {
        val actual = listOf("A", "C", "D", "E", "B")
        val expected = listOf("A", "B", "C", "D", "E")
        quickSort(actual, 0, actual.size - 1)
        assertEquals(expected, actual)
    }
}