package com.playground.home.di

import com.playground.home.data.remote.ApiClient.createApi
import com.playground.home.data.remote.TrendingApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class TrendingClientApi

    @Singleton
    @Provides
    fun createOkHttpClient(): OkHttpClient {
        return com.playground.home.data.remote.ApiClient.createOkHttpClient()
    }

    @Singleton
    @TrendingClientApi
    @Provides
    fun createTrendingApi(okHttpClient: OkHttpClient): TrendingApi {
        return createApi("", okHttpClient, "https://ghapi.huchen.dev/")
    }
}