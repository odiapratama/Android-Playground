package com.playground.feature.home.data.repository

import com.playground.feature.home.data.model.ResultData
import com.playground.feature.home.data.model.TrendingItem
import com.playground.feature.home.data.remote.TrendingApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class TrendingRepositoryImpl @Inject constructor(
    private val trendingApi: TrendingApi
) : TrendingRepository {
    override suspend fun getTrending(): ResultData<List<TrendingItem>> {
        var result: ResultData<List<TrendingItem>>
        withContext(Dispatchers.IO) {
            result = try {
                val data = trendingApi.getTrending()
                ResultData.Success(data)
            } catch (e: Exception) {
                ResultData.Error(e)
            }
        }
        return result
    }
}