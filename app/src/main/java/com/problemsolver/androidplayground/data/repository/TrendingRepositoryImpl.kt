package com.problemsolver.androidplayground.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.problemsolver.androidplayground.data.model.TrendingItem
import com.problemsolver.androidplayground.data.remote.TrendingApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.problemsolver.androidplayground.data.model.ResultData
import java.lang.Exception
import javax.inject.Inject

class TrendingRepositoryImpl @Inject constructor(
    private val trendingApi: TrendingApi
) : TrendingRepository {
    override suspend fun getTrending(): LiveData<ResultData<List<TrendingItem>>> {
        val result = MutableLiveData<ResultData<List<TrendingItem>>>()
        result.postValue(ResultData.Loading)
        withContext(Dispatchers.IO) {
            try {
                val data = trendingApi.getTrending()
                result.postValue(ResultData.Success(data))
            } catch (e: Exception) {
                result.postValue(ResultData.Error(e))
            }
        }
        return result
    }
}