package com.playground.core.ui.navigation

import androidx.navigation.NavController

interface NavContract {
    val controller: NavController?
    fun navigateUp()
}