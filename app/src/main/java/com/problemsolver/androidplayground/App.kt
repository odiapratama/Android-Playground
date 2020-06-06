package com.problemsolver.androidplayground

import android.app.Application
import com.problemsolver.androidplayground.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(viewModelModule)
        }
    }
}