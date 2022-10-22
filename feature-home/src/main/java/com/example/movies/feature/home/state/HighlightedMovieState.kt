package com.example.movies.feature.home.state

import com.example.movies.core.common.UiText
import com.example.movies.core.model.home.TrendingMovie

sealed class HighlightedMovieState {

    object Loading : HighlightedMovieState()

    data class DataLoaded(
        val data: TrendingMovie
    ) : HighlightedMovieState()


    data class Error(
        val errorMessage: UiText,
    ) : HighlightedMovieState()

}