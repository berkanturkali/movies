package com.example.movies.feature.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.movies_compose.feature.home.R

@Composable
fun UpcomingMovies(
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.upcoming_movies_title),
    upcomingMovies: List<String>,
    isLoading: Boolean,
) {
    MovieSection(title = title, modifier = modifier) {
        UpcomingMoviesList(isLoading = isLoading, upcomingMovies = upcomingMovies)
    }

}