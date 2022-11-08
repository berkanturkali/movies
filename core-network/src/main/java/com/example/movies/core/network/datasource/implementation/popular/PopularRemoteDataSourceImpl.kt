package com.example.movies.core.network.datasource.implementation.popular

import com.example.movies.core.network.datasource.abstraction.popular.PopularRemoteDataSource
import com.example.movies.core.network.model.popular.PopularMoviesResponseDTO
import com.example.movies.core.network.service.movies.MoviesService
import retrofit2.Response
import javax.inject.Inject

class PopularRemoteDataSourceImpl @Inject constructor(
    private val moviesService: MoviesService
) : PopularRemoteDataSource {
    override suspend fun fetchPopularMovies(): Response<PopularMoviesResponseDTO> {
        return moviesService.fetchPopularMovies()
    }
}