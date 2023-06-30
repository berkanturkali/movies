package com.example.movies.core.network.datasource.abstraction.movies

import com.example.movies.core.network.model.credit.CreditsResponseDTO
import com.example.movies.core.network.model.moviedetails.KeywordsResponseDTO
import com.example.movies.core.network.model.moviedetails.MovieDetailsResponseDTO
import com.example.movies.core.network.model.moviedetails.RecommendationsResponseDTO
import com.example.movies.core.network.model.moviedetails.VideosResponseDTO
import com.example.movies.core.network.model.review.ReviewsResponseDTO
import retrofit2.Response

interface MoviesRemoteDataSource {

    suspend fun fetchMovie(id: Int): Response<MovieDetailsResponseDTO>
    suspend fun fetchCredits(id: Int): Response<CreditsResponseDTO>
    suspend fun fetchReviews(id: Int): Response<ReviewsResponseDTO>
    suspend fun fetchKeywords(id: Int): Response<KeywordsResponseDTO>
    suspend fun fetchVideos(id: Int): Response<VideosResponseDTO>
    suspend fun fetchRecommendations(id: Int): Response<RecommendationsResponseDTO>

}