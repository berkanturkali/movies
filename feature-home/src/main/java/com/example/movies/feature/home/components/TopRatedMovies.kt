package com.example.movies.feature.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.movies_compose.feature.home.R

@Composable
fun TopRatedMovies(
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.top_rated_movies_title),
    topRatedMovies: List<String>,
    isLoading: Boolean,
) {
    MovieSection(title = title, modifier = modifier) {
        TopRatedMoviesList(isLoading = isLoading, topRatedMovies = topRatedMovies)
    }

}