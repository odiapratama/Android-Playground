package com.playground.benchmark

import androidx.benchmark.macro.ExperimentalMetricApi
import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.TraceSectionMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FrameTimingBenchmark {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @OptIn(ExperimentalMetricApi::class)
    @Test
    fun startup() = benchmarkRule.measureRepeated(
        packageName = "com.problemsolver.androidplayground",
        metrics = listOf(
            FrameTimingMetric(),
            TraceSectionMetric("RV CreateView"),
            TraceSectionMetric("RV OnBindView"),
        ),
        iterations = 5,
    ) {
        pressHome()
        startActivityAndWait()
    }
}