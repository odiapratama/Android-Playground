package com.playground.android.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.playground.android.BuildConfig
import com.playground.android.data.remote.ApiClient
import com.playground.android.data.remote.TrendingApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import okhttp3.OkHttpClient
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
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
        return PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(
                produceNewData = { emptyPreferences() }
            ),
            migrations = listOf(SharedPreferencesMigration(context, BuildConfig.DataStoreName)),
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { context.preferencesDataStoreFile(BuildConfig.DataStoreName) }
        )
    }
}