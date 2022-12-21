package com.playground.feature.main.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.playground.feature.main.R
import com.playground.feature.main.navigation.screen.MainNavScreen
import com.playground.feature.main.navigation.space.MainNavSpace
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @Inject
    lateinit var space: MainNavSpace

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        val throwable = getErrorIntent(intent)
        throwable?.message?.let {
            space.orbit.navigateTo(MainNavScreen.Error)
        }
    }

    private fun getErrorIntent(intent: Intent): Throwable? {
        return try {
            Gson().fromJson(intent.getStringExtra("error"), Throwable::class.java)
        } catch (e: Exception) {
            Timber.d("Error parsing intent data", e)
            null
        }
    }

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
