package com.example.movies.core.network.datasource.abstraction.movies

import com.example.movies.core.network.model.moviedetails.MovieDetailsResponseDTO
import retrofit2.Response

interface MoviesRemoteDataSource {

    suspend fun fetchMovie(id: Int): Response<MovieDetailsResponseDTO>
}