package com.example.movies.feature.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.movies_compose.feature.home.R

@Composable
fun PopularMovies(
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.popular_movies_title),
    popularMovies: List<String>,
    isLoading: Boolean,
) {
    MovieSection(title = title, modifier = modifier) {
        PopularMoviesList(isLoading = isLoading, popularMovies = popularMovies)
    }

}