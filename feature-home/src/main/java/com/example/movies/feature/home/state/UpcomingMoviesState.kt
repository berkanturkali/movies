package com.example.movies.feature.home.state

import com.example.movies.core.common.UiText
import com.example.movies.core.model.home.UpcomingMovie

sealed class UpcomingMoviesState {

    object Loading : UpcomingMoviesState()

    data class DataLoaded(
        val data: List<UpcomingMovie>
    ) : UpcomingMoviesState()

    data class Error(
        val errorMessage: UiText
    ) : UpcomingMoviesState()
}