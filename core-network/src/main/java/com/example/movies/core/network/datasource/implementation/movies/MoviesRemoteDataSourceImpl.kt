package com.example.movies.core.network.datasource.implementation.movies

import com.example.movies.core.network.datasource.abstraction.movies.MoviesRemoteDataSource
import com.example.movies.core.network.model.credit.CreditsResponseDTO
import com.example.movies.core.network.model.moviedetails.KeywordsResponseDTO
import com.example.movies.core.network.model.moviedetails.MovieDetailsResponseDTO
import com.example.movies.core.network.model.review.ReviewsResponseDTO
import com.example.movies.core.network.service.movies.MoviesService
import retrofit2.Response
import javax.inject.Inject

class MoviesRemoteDataSourceImpl @Inject constructor(
    private val service: MoviesService
) : MoviesRemoteDataSource {

    override suspend fun fetchMovie(id: Int): Response<MovieDetailsResponseDTO> {
        return service.fetchMovie(id)
    }

    override suspend fun fetchCredits(id: Int): Response<CreditsResponseDTO> {
        return service.fetchCredits(id)
    }

    override suspend fun fetchReviews(id: Int): Response<ReviewsResponseDTO> {
        return service.fetchReviews(id = id)
    }

    override suspend fun fetchKeywords(id: Int): Response<KeywordsResponseDTO> {
        return service.fetchKeywords(id)
    }
}