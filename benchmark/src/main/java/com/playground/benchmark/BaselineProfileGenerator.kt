package com.playground.benchmark

import androidx.benchmark.macro.ExperimentalBaselineProfilesApi
import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import androidx.test.uiautomator.Until
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalBaselineProfilesApi::class)
class BaselineProfileGenerator {

    @get:Rule
    val baselineProfileRule = BaselineProfileRule()

    @Test
    fun appStartupAndUserJourneys() {
        baselineProfileRule.collectBaselineProfile(packageName = "com.problemsolver.androidplayground") {
            // App startup journey
            startActivityAndWait()

            device.findObject(By.text("Android Playground")).clickAndWait(Until.newWindow(), 1_000)
            device.findObject(By.res("rvTrending")).also {
                it.fling(Direction.DOWN)
                it.fling(Direction.UP)
            }
            device.pressBack()
        }
    }
}