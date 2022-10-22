package com.example.movies.core.network.service.nowplaying

import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.endpoints.nowplaying.NowPlayingEndpoints.NOW_PLAYING_MOVIES_ENDPOINT
import com.example.movies.core.network.model.nowplaying.NowPlayingResponseDTO
import com.example.movies.core.network.service.base.BaseService
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NowPlayingService : BaseService {

    @GET(NOW_PLAYING_MOVIES_ENDPOINT)
    suspend fun fetchNowPlayingMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("page") page: Int = 1,
    ): Response<NowPlayingResponseDTO>
}