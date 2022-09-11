package com.example.movies.feature.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.movies_compose.feature.home.R

@Composable
fun NowPlayingMovies(
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.now_playing_movies_title),
    isLoading: Boolean,
    nowPlayingMovies: List<String>,
) {
    MovieSection(title = title, modifier = modifier) {
        NowPlayingMoviesList(isLoading = isLoading, nowPlayingMovies = nowPlayingMovies)
    }
}