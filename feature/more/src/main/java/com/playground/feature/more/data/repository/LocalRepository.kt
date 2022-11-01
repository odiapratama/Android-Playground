package com.playground.feature.more.data.repository

import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    suspend fun setExampleData(data: String)
    suspend fun getExampleData(): Flow<String>
}