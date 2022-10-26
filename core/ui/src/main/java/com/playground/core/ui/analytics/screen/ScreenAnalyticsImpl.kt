package com.playground.core.ui.analytics.screen

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.playground.core.ui.ext.getScreenName

class ScreenAnalyticsImpl : ScreenAnalyticsContract, LifecycleEventObserver {

    override fun registerLifecycleOwner(lifecycleOwner: LifecycleOwner) {
        lifecycleOwner.lifecycle.addObserver(this)
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_RESUME -> {
                /**
                 * add tracking function
                 * {@link ContextExt#getScreenName()}
                 */
                source.getScreenName()
            }

            Lifecycle.Event.ON_PAUSE -> {
                /**
                 * add tracking function
                 * {@link ContextExt#getScreenName()}
                 */
                source.getScreenName()
            }
            else -> Unit
        }
    }
}