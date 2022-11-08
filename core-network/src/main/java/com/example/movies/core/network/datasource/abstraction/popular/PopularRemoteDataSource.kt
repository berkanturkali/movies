package com.example.movies.core.network.datasource.abstraction.popular

import com.example.movies.core.network.model.popular.PopularMoviesResponseDTO
import retrofit2.Response

interface PopularRemoteDataSource {

    suspend fun fetchPopularMovies(): Response<PopularMoviesResponseDTO>
}