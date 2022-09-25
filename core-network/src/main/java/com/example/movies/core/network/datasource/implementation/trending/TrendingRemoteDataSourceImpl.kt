package com.example.movies.core.network.datasource.implementation.trending

import com.example.movies.core.network.datasource.abstraction.trending.TrendingRemoteDataSource
import com.example.movies.core.network.model.trending.TrendingResponseDTO
import com.example.movies.core.network.service.trending.TrendingService
import retrofit2.Response
import javax.inject.Inject

class TrendingRemoteDataSourceImpl @Inject constructor(
    private val trendingService: TrendingService
) : TrendingRemoteDataSource {
    override suspend fun fetchTopTrendingMovies(): Response<TrendingResponseDTO> {
        return trendingService.fetchTopTrendingMovies()
    }
}