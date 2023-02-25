package com.example.movies.core.network.datasource.implementation.top_rated

import com.example.movies.core.network.datasource.abstraction.top_rated.TopRatedMoviesRemoteDataSource
import com.example.movies.core.network.model.top_rated.TopRatedMoviesResponseDTO
import com.example.movies.core.network.service.movies.MoviesService
import retrofit2.Response
import javax.inject.Inject

class TopRatedMoviesRemoteDataSourceImpl @Inject constructor(
    private val service: MoviesService
) : TopRatedMoviesRemoteDataSource {
    override suspend fun fetchTopRatedMovies(): Response<TopRatedMoviesResponseDTO> {
        return service.fetchTopRatedMovies()
    }
}