package com.example.movies.feature.home.state

import com.example.movies.core.common.UiText
import com.example.movies.core.model.home.PopularMovie

sealed class PopularMoviesState {

    object Loading : PopularMoviesState()

    data class DataLoaded(val data: List<PopularMovie>) : PopularMoviesState()

    data class Error(
        val errorMessage: UiText
    ) : PopularMoviesState()
}