package com.problemsolver.androidplayground.ui.splash

import androidx.navigation.findNavController
import com.problemsolver.androidplayground.R
import com.problemsolver.androidplayground.base.fragment.BaseFragment
import com.problemsolver.androidplayground.databinding.FragmentSplashBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    private val navController by lazy { requireView().findNavController() }

    override fun setLayout() = R.layout.fragment_splash

    override fun viewOnReady() {
        GlobalScope.launch {
            delay(3000)
            launch(Dispatchers.Main) {
                navController.navigate(
                    SplashFragmentDirections.splashFragmentToMenuFragment()
                )
            }
        }
    }

}