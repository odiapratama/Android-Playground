package com.playground.android.data.repository

import com.playground.android.data.model.TrendingItem
import com.playground.android.data.remote.TrendingApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.playground.android.data.model.ResultData
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