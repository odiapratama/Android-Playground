package com.problemsolver.androidplayground.di

import com.problemsolver.androidplayground.data.remote.TrendingApi
import com.problemsolver.androidplayground.data.repository.TrendingRepository
import com.problemsolver.androidplayground.data.repository.TrendingRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun trendingRepository(@AppModule.TrendingClientApi trendingApi: TrendingApi): TrendingRepository {
        return TrendingRepositoryImpl(trendingApi)
    }
}