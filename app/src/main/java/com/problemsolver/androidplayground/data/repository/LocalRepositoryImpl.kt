package com.problemsolver.androidplayground.data.repository

import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : LocalRepository {

    private val preferences = preferencesKey<String>("TEXT_INPUT")

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