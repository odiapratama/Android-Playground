package com.playground.android.data.remote

import com.playground.android.data.model.TrendingItem
import retrofit2.http.GET
import retrofit2.http.Query

interface TrendingApi {
    @GET("repositories")
    suspend fun getTrending(
        @Query("language") language: String = "kotlin",
        @Query("since") since: String = "daily"
    ): List<TrendingItem>
}