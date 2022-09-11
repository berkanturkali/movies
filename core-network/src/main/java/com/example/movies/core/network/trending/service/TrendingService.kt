package com.example.movies.core.network.trending.service

import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.base.BaseService
import com.example.movies.core.network.trending.TrendingMediaType
import com.example.movies.core.network.trending.TrendingTimeWindow
import com.example.movies.core.network.trending.endpoints.TrendingEndpoints
import com.example.movies.core.network.trending.model.TrendingResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TrendingService : BaseService {

    @GET(TrendingEndpoints.TRENDING_ENDPOINT)
    suspend fun fetchTopTrendingMovies(
        @Path(TrendingEndpoints.MEDIA_TYPE_PATH) mediaType: String = TrendingMediaType.MOVIE.type,
        @Path(TrendingEndpoints.TIME_WINDOW_PATH) timeWindow: String = TrendingTimeWindow.DAY.timeWindow,
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int = 1,
    ): TrendingResponseDTO

}