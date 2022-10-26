package com.playground.android.data.repository

import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    suspend fun setExampleData(data: String)
    suspend fun getExampleData(): Flow<String>
}