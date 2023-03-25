package com.example.movies.feature.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.examle.movies.core.ui.components.fadeModifier
import com.example.movies.core.model.home.TrendingMovie
import com.example.movies.feature.home.state.TrendingMoviesState
import com.example.movies_compose.feature.home.R

@Composable
fun TrendingMovies(
    trendingMoviesState: TrendingMoviesState,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.trending_movies_title),
) {

    val context = LocalContext.current

    MovieSection(title = title, modifier = modifier) {
        when (trendingMoviesState) {
            is TrendingMoviesState.DataLoaded -> {
                TrendingMoviesList(
                    childModifier = Modifier.fadeModifier(false),
                    trendingMovies = trendingMoviesState.data
                )
            }
            is TrendingMoviesState.Error -> {
                ErrorView(
                    message = trendingMoviesState.errorMessage.asString(context)!!,
                    onRetryClick = onRetryClick
                )
            }
            TrendingMoviesState.Loading -> {
                TrendingMoviesList(
                    trendingMovies = (0..10).map { TrendingMovie() },
                    childModifier = Modifier.fadeModifier(true)
                )
            }
        }
    }
}

