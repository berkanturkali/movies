package com.example.movies.feature.home.state

import com.example.movies.core.common.UiText
import com.example.movies.core.model.home.TopRatedMovie

sealed class TopRatedMoviesState {

    object Loading : TopRatedMoviesState()

    data class TopRatedMovies(val data: List<TopRatedMovie>) : TopRatedMoviesState()

    data class Error(
        val errorMessage: UiText
    ) : TopRatedMoviesState()
}