package com.example.movies.core.network.datasource.abstraction.movies

import com.example.movies.core.network.model.credit.CreditsResponseDTO
import com.example.movies.core.network.model.moviedetails.MovieDetailsResponseDTO
import com.example.movies.core.network.model.review.ReviewDTO
import retrofit2.Response

interface MoviesRemoteDataSource {

    suspend fun fetchMovie(id: Int): Response<MovieDetailsResponseDTO>
    suspend fun fetchCredits(id: Int): Response<CreditsResponseDTO>
    suspend fun fetchReviews(id: Int, page: Int): List<ReviewDTO>

}