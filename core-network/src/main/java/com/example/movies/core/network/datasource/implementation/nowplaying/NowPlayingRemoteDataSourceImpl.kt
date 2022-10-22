package com.example.movies.core.network.datasource.implementation.nowplaying

import com.example.movies.core.network.datasource.abstraction.nowplaying.NowPlayingRemoteDataSource
import com.example.movies.core.network.model.nowplaying.NowPlayingResponseDTO
import com.example.movies.core.network.service.nowplaying.NowPlayingService
import retrofit2.Response
import javax.inject.Inject

class NowPlayingRemoteDataSourceImpl @Inject constructor(
    private val nowPlayingService: NowPlayingService
) : NowPlayingRemoteDataSource {
    override suspend fun fetchNowPlayingMovies(): Response<NowPlayingResponseDTO> {
        return nowPlayingService.fetchNowPlayingMovies()
    }
}