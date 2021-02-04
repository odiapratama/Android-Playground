package com.problemsolver.androidplayground.di

import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import com.problemsolver.androidplayground.data.remote.TrendingApi
import com.problemsolver.androidplayground.data.repository.LocalRepository
import com.problemsolver.androidplayground.data.repository.LocalRepositoryImpl
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

    @Singleton
    @Provides
    fun createLocalRepository(@AppModule.ExampleDataStore dataStore: DataStore<Preferences>): LocalRepository {
        return LocalRepositoryImpl(dataStore)
    }
}