package com.example.movies.feature.details.movie.usecases

import javax.inject.Inject

data class MovieDetailsScreenUseCases @Inject constructor(
    val fetchMovie: FetchMovieUseCase,
    val fetchCast: FetchCastUseCase,
    val fetchReviews: FetchReviewsUseCase,
    val fetchKeywords: FetchKeywordsUseCase,
    val fetchVideos: FetchVideosUseCase,
    val fetchRecommendations: FetchRecommendationsUseCase
)