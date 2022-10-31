package com.playground.android.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.playground.android.data.repository.LocalRepository
import com.playground.android.data.repository.LocalRepositoryImpl
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
    fun createLocalRepository(@AppModule.ExampleDataStore dataStore: DataStore<Preferences>): LocalRepository {
        return LocalRepositoryImpl(dataStore)
    }
}