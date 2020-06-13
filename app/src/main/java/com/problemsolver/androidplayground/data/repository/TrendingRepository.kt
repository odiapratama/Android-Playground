package com.problemsolver.androidplayground.data.repository

import androidx.lifecycle.LiveData
import com.problemsolver.androidplayground.data.model.ResultData
import com.problemsolver.androidplayground.data.model.TrendingItem

interface TrendingRepository {
    suspend fun getTrending(): LiveData<ResultData<List<TrendingItem>>>
}