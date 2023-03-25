package com.example.movies.feature.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.movies.core.model.home.TopRatedMovie

@Composable
fun TopRatedMoviesList(
    modifier: Modifier = Modifier,
    childModifier: Modifier = Modifier,
    topRatedMovies: List<TopRatedMovie>,
) {

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            dimensionResource(id = com.examle.movies.core.ui.R.dimen.dimen_16)
        ),
    ) {
        topRatedMovies(
            topRatedMovies = topRatedMovies,
            childModifier = childModifier
        )
    }
}

private fun LazyListScope.topRatedMovies(
    topRatedMovies: List<TopRatedMovie>,
    childModifier: Modifier
) {
    items(topRatedMovies) { movie ->
        MoviePoster(
            image = movie.image,
            childModifier = childModifier
        )
    }
}