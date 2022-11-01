package com.playground.feature.more.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : LocalRepository {

    private val preferences = stringPreferencesKey("TEXT_INPUT")

    override suspend fun setExampleData(data: String) {
        dataStore.edit {
            it[preferences] = data
        }
    }

    override suspend fun getExampleData(): Flow<String> {
        return dataStore.data.map {
            it[preferences] ?: ""
        }
    }
}