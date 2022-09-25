package com.example.movies.core.network.datasource.abstraction.trending

import com.example.movies.core.network.model.trending.TrendingDTO
import com.example.movies.core.network.model.trending.TrendingResponseDTO
import retrofit2.Response

interface TrendingRemoteDataSource {

    suspend fun fetchTopTrendingMovies(): Response<TrendingResponseDTO>
}