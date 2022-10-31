package com.playground.home.data.repository

import com.playground.home.data.model.ResultData
import com.playground.home.data.model.TrendingItem

interface TrendingRepository {
    suspend fun getTrending(): ResultData<List<TrendingItem>>
}