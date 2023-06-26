package com.example.movies.core.network.datasource.abstraction.movies

import com.example.movies.core.network.model.credit.CreditsResponseDTO
import com.example.movies.core.network.model.moviedetails.MovieDetailsResponseDTO
import retrofit2.Response
import retrofit2.http.Path

interface MoviesRemoteDataSource {

    suspend fun fetchMovie(id: Int): Response<MovieDetailsResponseDTO>
    suspend fun fetchCredits(id: Int): Response<CreditsResponseDTO>

}