package com.playground.home.di

import com.playground.home.data.remote.TrendingApi
import com.playground.home.data.repository.TrendingRepository
import com.playground.home.data.repository.TrendingRepositoryImpl
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
    fun trendingRepository(@AppModule.TrendingClientApi trendingApi: TrendingApi): TrendingRepository {
        return TrendingRepositoryImpl(trendingApi)
    }
}