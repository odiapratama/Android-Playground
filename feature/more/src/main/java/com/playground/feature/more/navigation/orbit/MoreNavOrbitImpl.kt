package com.playground.feature.more.navigation.orbit

import android.app.Activity
import androidx.fragment.app.Fragment
import com.playground.feature.more.ui.MoreFragmentDirections

class MoreNavOrbitImpl(
    override val activity: Activity? = null,
    override val fragment: Fragment? = null
) : MoreNavOrbit {

    override fun toJetpack() {
        nextNavigation(MoreFragmentDirections.actionMoreToJetpackJourney())
    }

    override fun toUiDrag() {
        nextNavigation(MoreFragmentDirections.actionMoreToViewExploreJourney())
    }

    override fun toThreading() {
        nextNavigation(MoreFragmentDirections.actionMoreToThreadingJourney())
    }

    override fun toError() {
        throw Error("Error from more fragment button error")
    }
}