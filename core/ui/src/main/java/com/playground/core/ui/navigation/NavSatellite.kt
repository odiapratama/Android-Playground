package com.playground.core.ui.navigation

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.playground.core.ui.R

interface NavSatellite : NavContract {

    val context: Context

    override val controller: NavController?
        get() = ((context as FragmentActivity).supportFragmentManager.findFragmentById(R.id.navSatellite) as NavHostFragment).navController

    override fun navigateUp() {
        controller?.navigateUp()
    }
}