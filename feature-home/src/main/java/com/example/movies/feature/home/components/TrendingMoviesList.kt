package com.example.movies.feature.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.movies.core.model.home.TrendingMovie
import timber.log.Timber

@Composable
fun TrendingMoviesList(
    trendingMovies: List<TrendingMovie>,
    onTrendingMovieClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    childModifier: Modifier = Modifier,
) {

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            dimensionResource(id = com.examle.movies.core.ui.R.dimen.dimen_16)
        ),
    ) {
        trendingMovies(
            trendingMovies = trendingMovies,
            childModifier = childModifier,
            onTrendingMovieClick = onTrendingMovieClick
        )
    }
}

private fun LazyListScope.trendingMovies(
    onTrendingMovieClick: (Int) -> Unit,
    trendingMovies: List<TrendingMovie>,
    childModifier: Modifier
) {
    items(trendingMovies) { movie ->
        MoviePoster(
            image = movie.image,
            childModifier = childModifier,
            onItemClick = {
                movie.id?.let { onTrendingMovieClick(it) }
            })
    }
}