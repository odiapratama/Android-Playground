package com.problemsolver.androidplayground.di

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import com.problemsolver.androidplayground.BuildConfig
import com.problemsolver.androidplayground.data.remote.ApiClient
import com.problemsolver.androidplayground.data.remote.TrendingApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class TrendingClientApi

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class ExampleDataStore

    @Singleton
    @Provides
    fun createOkHttpClient(): OkHttpClient {
        return ApiClient.createOkHttpClient()
    }

    @Singleton
    @TrendingClientApi
    @Provides
    fun createTrendingApi(okHttpClient: OkHttpClient): TrendingApi {
        return ApiClient.createApi("", okHttpClient, BuildConfig.BASE_URL)
    }

    @Singleton
    @ExampleDataStore
    @Provides
    fun dataStoreRepository(@ApplicationContext context: Context): DataStore<Preferences> {
        return context.createDataStore("example")
    }
}