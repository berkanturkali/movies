package com.example.movies.feature.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource

@Composable
fun TopRatedMoviesList(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    topRatedMovies: List<String>,
) {

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = com.examle.movies.core.ui.R.dimen.dimen_16)),
    ) {
        topRatedMovies(topRatedMovies = topRatedMovies)
    }
}

private fun LazyListScope.topRatedMovies(topRatedMovies: List<String>) {
    items(topRatedMovies) { movie ->
        MoviePoster(image = movie)
    }
}