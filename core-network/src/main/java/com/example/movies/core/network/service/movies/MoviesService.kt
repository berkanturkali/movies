package com.example.movies.core.network.service.movies

import com.example.movies.core.network.endpoints.movies.MoviesEndpoints
import com.example.movies.core.network.model.credit.CreditsResponseDTO
import com.example.movies.core.network.model.moviedetails.KeywordsResponseDTO
import com.example.movies.core.network.model.moviedetails.MovieDetailsResponseDTO
import com.example.movies.core.network.model.review.ReviewsResponseDTO
import com.example.movies.core.network.service.base.BaseService
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesService : BaseService {
    @GET(MoviesEndpoints.MOVIE_DETAILS_ENDPOINT)
    suspend fun fetchMovie(@Path("movie_id") id: Int): Response<MovieDetailsResponseDTO>

    @GET(MoviesEndpoints.CREDITS_ENDPOINT)
    suspend fun fetchCredits(@Path("movie_id") id: Int): Response<CreditsResponseDTO>

    @GET(MoviesEndpoints.REVIEWS_ENDPOINT)
    suspend fun fetchReviews(
        @Path("movie_id") id: Int,
    ): Response<ReviewsResponseDTO>

    @GET(MoviesEndpoints.KEYWORDS_ENDPOINT)
    suspend fun fetchKeywords(
        @Path("movie_id") id: Int,
    ): Response<KeywordsResponseDTO>


}