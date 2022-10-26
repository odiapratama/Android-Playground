package com.playground.android.data.repository

import com.playground.android.data.model.ResultData
import com.playground.android.data.model.TrendingItem

interface TrendingRepository {
    suspend fun getTrending(): ResultData<List<TrendingItem>>
}