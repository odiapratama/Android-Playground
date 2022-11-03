package com.playground.feature.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val navController by lazy { requireView().findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        lifecycleScope.launch {
            delay(3000)
            launch(Dispatchers.Main) {
                navController.navigate(R.id.splashFragmentToMenuFragment)

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