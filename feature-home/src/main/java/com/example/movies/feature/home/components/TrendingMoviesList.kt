package com.example.movies.feature.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource

@Composable
fun TrendingMoviesList(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
) {

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = com.examle.movies.core.ui.R.dimen.dimen_16)),
    ) {
        trendingMovies(trendingMovies = (0..20).map { it.toString() })
    }
}

private fun LazyListScope.trendingMovies(trendingMovies: List<String>) {
    items(trendingMovies) { movie ->
        MoviePoster(image = movie)
    }
}