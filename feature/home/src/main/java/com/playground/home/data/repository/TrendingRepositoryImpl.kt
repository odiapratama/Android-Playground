package com.playground.home.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class TrendingRepositoryImpl @Inject constructor(
    private val trendingApi: com.playground.home.data.remote.TrendingApi
) : TrendingRepository {
    override suspend fun getTrending(): com.playground.home.data.model.ResultData<List<com.playground.home.data.model.TrendingItem>> {
        var result: com.playground.home.data.model.ResultData<List<com.playground.home.data.model.TrendingItem>>
        withContext(Dispatchers.IO) {
            result = try {
                val data = trendingApi.getTrending()
                com.playground.home.data.model.ResultData.Success(data)
            } catch (e: Exception) {
                com.playground.home.data.model.ResultData.Error(e)
            }
        }
        return result
    }
}