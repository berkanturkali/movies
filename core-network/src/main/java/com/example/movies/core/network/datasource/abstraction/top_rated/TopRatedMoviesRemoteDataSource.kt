package com.example.movies.core.network.datasource.abstraction.top_rated

import com.example.movies.core.network.model.top_rated.TopRatedMoviesResponseDTO
import retrofit2.Response

interface TopRatedMoviesRemoteDataSource {

    suspend fun fetchTopRatedMovies(): Response<TopRatedMoviesResponseDTO>
}