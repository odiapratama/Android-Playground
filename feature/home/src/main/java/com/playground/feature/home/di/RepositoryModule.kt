package com.playground.feature.home.di

import com.playground.feature.home.data.remote.TrendingApi
import com.playground.feature.home.data.repository.TrendingRepository
import com.playground.feature.home.data.repository.TrendingRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun trendingRepository(@HomeModule.TrendingClientApi trendingApi: TrendingApi): TrendingRepository {
        return TrendingRepositoryImpl(trendingApi)
    }
}