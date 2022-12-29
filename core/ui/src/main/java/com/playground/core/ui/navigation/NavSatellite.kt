package com.playground.core.ui.navigation

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.playground.core.ui.R

interface NavSatellite : NavContract {

    override val activity: Activity?

    override val fragment: Fragment?

    override val controller: NavController?
        get() = ((activity as? FragmentActivity?)?.supportFragmentManager?.findFragmentById(R.id.navSatellite) as? NavHostFragment?)?.navController
            ?: fragment?.findNavController()

    override fun navigateUp() {
        controller?.navigateUp()
    }
}