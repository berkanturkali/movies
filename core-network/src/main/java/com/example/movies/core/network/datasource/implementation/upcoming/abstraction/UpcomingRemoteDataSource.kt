package com.example.movies.core.network.datasource.implementation.upcoming.abstraction

import com.example.movies.core.network.model.upcoming.UpcomingMoviesResponseDTO
import retrofit2.Response

interface UpcomingRemoteDataSource {

    suspend fun fetchUpcomingMovies(): Response<UpcomingMoviesResponseDTO>
}