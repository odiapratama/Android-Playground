package com.playground.feature.home.data.repository

import com.playground.feature.home.data.model.ResultData
import com.playground.feature.home.data.model.TrendingItem

interface TrendingRepository {
    suspend fun getTrending(): ResultData<List<TrendingItem>>
}