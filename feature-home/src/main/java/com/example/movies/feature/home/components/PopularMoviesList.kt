package com.example.movies.feature.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.examle.movies.core.ui.R
import com.example.movies.core.model.home.PopularMovie

@Composable
fun PopularMoviesList(
    popularMovies: List<PopularMovie>,
    modifier: Modifier = Modifier,
    childModifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.dimen_16)),
    ) {
        popularMovies(popularMovies = popularMovies, childModifier = childModifier)
    }
}

private fun LazyListScope.popularMovies(
    popularMovies: List<PopularMovie>,
    childModifier: Modifier = Modifier,
) {
    items(popularMovies) { movie ->
        MoviePoster(image = movie.image, childModifier = childModifier)
    }
}