package com.example.movies.feature.home.state

import com.example.movies.core.common.UiText
import com.example.movies.core.model.home.TrendingMovie

sealed class TrendingMoviesState {

    object Loading : TrendingMoviesState()

    data class DataLoaded(
        val data: List<TrendingMovie>
    ) : TrendingMoviesState()


    data class Error(
        val errorMessage: UiText,
    ) : TrendingMoviesState()

}