package com.example.movies.core.network.datasource.abstraction.nowplaying

import com.example.movies.core.network.model.nowplaying.NowPlayingResponseDTO
import retrofit2.Response

interface NowPlayingRemoteDataSource {

    suspend fun fetchNowPlayingMovies(): Response<NowPlayingResponseDTO>
}