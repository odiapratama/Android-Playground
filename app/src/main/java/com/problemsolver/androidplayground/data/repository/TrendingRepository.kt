package com.problemsolver.androidplayground.data.repository

import com.problemsolver.androidplayground.data.model.ResultData
import com.problemsolver.androidplayground.data.model.TrendingItem

interface TrendingRepository {
    suspend fun getTrending(): ResultData<List<TrendingItem>>
}