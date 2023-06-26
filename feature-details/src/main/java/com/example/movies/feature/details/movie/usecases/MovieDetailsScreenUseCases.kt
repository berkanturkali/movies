package com.example.movies.feature.details.movie.usecases

import javax.inject.Inject

data class MovieDetailsScreenUseCases @Inject constructor(
    val fetchMovie: FetchMovieUseCase
)