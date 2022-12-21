package com.playground.android

import android.app.Application
import android.content.Intent
import com.google.gson.Gson
import com.playground.core.utils.CrashHandler
import com.playground.feature.main.ui.MainActivity
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        CrashHandler.initialize {
            Timber.d("Get error from App, error: %s", it)
            val intent = Intent(this, MainActivity::class.java)
            val errorJson = Gson().toJson(it)
            intent.putExtra("error", errorJson)
            startActivity(intent)
        }
    }
}