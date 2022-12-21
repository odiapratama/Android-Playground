package com.playground.feature.home.di

import com.playground.feature.home.data.remote.ApiClient
import com.playground.feature.home.data.remote.ApiClient.createApi
import com.playground.feature.home.data.remote.TrendingApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class TrendingClientApi

    @Singleton
    @Provides
    fun createOkHttpClient(): OkHttpClient {
        return ApiClient.createOkHttpClient()
    }

    @Singleton
    @TrendingClientApi
    @Provides
    fun createTrendingApi(okHttpClient: OkHttpClient): TrendingApi {
        return createApi("", okHttpClient, "https://ghapi.huchen.dev/")
    }
}