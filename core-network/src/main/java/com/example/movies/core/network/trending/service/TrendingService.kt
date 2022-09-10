package com.example.movies.core.network.trending.service

import com.example.movies.core.network.base.BaseService
import com.example.movies.core.network.trending.TrendingMediaType
import com.example.movies.core.network.trending.TrendingTimeWindow
import com.example.movies.core.network.trending.endpoints.TrendingEndpoints
import retrofit2.http.GET
import retrofit2.http.Path

interface TrendingService : BaseService {

    @GET(TrendingEndpoints.TRENDING_ENDPOINT)
    suspend fun fetchTrendingMovies(
        @Path(TrendingEndpoints.MEDIA_TYPE_PATH) mediaType: String = TrendingMediaType.MOVIE.type,
        @Path(TrendingEndpoints.TIME_WINDOW_PATH) timeWindow: String = TrendingTimeWindow.DAY.timeWindow,
    )

}