package com.playground.feature.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.playground.feature.splash.navigation.space.SplashNavSpace
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    @Inject
    lateinit var space: SplashNavSpace

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        lifecycleScope.launch {
            delay(3000)
            launch(Dispatchers.Main) {
                space.portal.toMenu()

                /**
                 * Navigate using id
                 * Add id in ids.xml
                 * */
                /*navController.navigate(R.id.splashFragmentToMenuFragment)*/

                /**
                 * Navigate using deeplink
                 * */
                /*val request = NavDeepLinkRequest.Builder
                    .fromUri("android-app://com.playground.feature.menu".toUri())
                    .build()
                navController.navigate(request)*/
            }
        }
    }
}