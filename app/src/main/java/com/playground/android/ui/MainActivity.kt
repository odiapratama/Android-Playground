package com.playground.android.ui

import androidx.appcompat.app.AppCompatActivity
import com.playground.android.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    /*fun showLoading(show: Boolean) {
        if (show) {
            binding.pbLoading.playAnimation()
            binding.pbLoading.toVisible()
        } else {
            binding.pbLoading.toGone()
            binding.pbLoading.cancelAnimation()
        }
    }*/
}
