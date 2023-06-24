package com.example.movies.core.network.service.movies

import com.example.movies.core.network.endpoints.movies.MoviesEndpoints
import com.example.movies.core.network.model.movie_details.MovieDetailsResponseDTO
import com.example.movies.core.network.service.base.BaseService
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesService : BaseService {
    @GET(MoviesEndpoints.MOVIE_DETAILS_ENDPOINT)
    suspend fun fetchMovie(@Path("movie_id") id: Int): Response<MovieDetailsResponseDTO>

}