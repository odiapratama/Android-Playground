package com.playground.core.ui.navigation

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController

interface NavContract {
    /**
     * Depends on where the inject is
     * */
    val activity: Activity?
    val fragment: Fragment?

    val controller: NavController?
    fun navigateUp()
}