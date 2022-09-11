package com.example.movies.feature.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.movies_compose.feature.home.R

@Composable
fun TrendingMovies(
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.trending_movies_title),
    trendingMovies: List<String>,
    isLoading: Boolean,
) {

    MovieSection(title = title, modifier = modifier) {
        TrendingMoviesList(isLoading = isLoading, trendingMovies = trendingMovies)
    }
}