package com.example.movies.feature.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.examle.movies.core.ui.components.MoviesErrorView
import com.examle.movies.core.ui.components.fadeModifier
import com.example.movies.core.model.home.PopularMovie
import com.example.movies.feature.home.state.PopularMoviesState
import com.example.movies_compose.feature.home.R

@Composable
fun PopularMovies(
    popularMoviesState: PopularMoviesState,
    onRetryClick: () -> Unit,
    onPopularMovieClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.popular_movies_title),
) {

    val context = LocalContext.current

    MovieSection(title = title, modifier = modifier) {
        when (popularMoviesState) {
            is PopularMoviesState.DataLoaded -> {
                PopularMoviesList(
                    popularMovies = popularMoviesState.data,
                    childModifier = Modifier.fadeModifier(false),
                    onPopularMovieClick = onPopularMovieClick
                )
            }
            is PopularMoviesState.Error -> {
                MoviesErrorView(
                    message = popularMoviesState.errorMessage.asString(context)!!,
                    onRetryClick = onRetryClick
                )
            }
            PopularMoviesState.Loading -> {
                PopularMoviesList(
                    popularMovies = (0..10).map { PopularMovie() },
                    childModifier = Modifier.fadeModifier(true),
                    onPopularMovieClick = {}
                )
            }
        }
    }

}