package com.example.movies.feature.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.examle.movies.core.ui.R

@Composable
fun PopularMoviesList(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    popularMovies: List<String>,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.dimen_16)),
    ) {
        popularMovies(popularMovies = popularMovies)
    }
}

private fun LazyListScope.popularMovies(popularMovies: List<String>) {
    items(popularMovies) { movie ->
        MoviePoster(image = movie)
    }
}