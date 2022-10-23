package com.example.movies.feature.home.state

import com.example.movies.core.common.UiText
import com.example.movies.core.model.home.NowPlayingMovie

sealed class NowPlayingMoviesState {

    object Loading : NowPlayingMoviesState()

    data class DataLoaded(
        val data: List<NowPlayingMovie>
    ) : NowPlayingMoviesState()

    data class Error(
        val errorMessage: UiText
    ) : NowPlayingMoviesState()
}