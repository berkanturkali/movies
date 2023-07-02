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
    topRatedMovies: List<TopRatedMovie>,
    onTopRatedMovieClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    childModifier: Modifier = Modifier,
) {

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            dimensionResource(id = com.examle.movies.core.ui.R.dimen.dimen_16)
        ),
    ) {
        topRatedMovies(
            topRatedMovies = topRatedMovies,
            childModifier = childModifier,
            onTopRatedMovieClick = onTopRatedMovieClick
        )
    }
}

private fun LazyListScope.topRatedMovies(
    topRatedMovies: List<TopRatedMovie>,
    onTopRatedMovieClick: (Int) -> Unit,
    childModifier: Modifier
) {
    items(topRatedMovies) { movie ->
        MoviePoster(
            image = movie.image,
            childModifier = childModifier,
            onItemClick = {
                movie.id?.let {
                    onTopRatedMovieClick(it)
                }
            }
        )
    }
}