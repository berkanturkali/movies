package com.example.movies.feature.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.movies.core.model.home.UpcomingMovie

@Composable
fun UpcomingMoviesList(
    modifier: Modifier = Modifier,
    childModifier: Modifier = Modifier,
    upcomingMovies: List<UpcomingMovie>,
) {

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            dimensionResource(id = com.examle.movies.core.ui.R.dimen.dimen_16)
        ),
    ) {
        upcomingMovies(upcomingMovies = upcomingMovies, childModifier = childModifier)
    }
}

private fun LazyListScope.upcomingMovies(
    upcomingMovies: List<UpcomingMovie>,
    childModifier: Modifier
) {
    items(upcomingMovies) { movie ->
        MoviePoster(image = movie.image, childModifier = childModifier)
    }
}