package com.example.movies.core.network.datasource.implementation.upcoming.implementation

import com.example.movies.core.network.datasource.implementation.upcoming.abstraction.UpcomingRemoteDataSource
import com.example.movies.core.network.model.upcoming.UpcomingMoviesResponseDTO
import com.example.movies.core.network.service.movies.MoviesService
import retrofit2.Response
import javax.inject.Inject

class UpcomingRemoteDataSourceImpl @Inject constructor(
    private val moviesService: MoviesService
) : UpcomingRemoteDataSource {
    override suspend fun fetchUpcomingMovies(): Response<UpcomingMoviesResponseDTO> {
        return moviesService.fetchUpcomingMovies()
    }
}