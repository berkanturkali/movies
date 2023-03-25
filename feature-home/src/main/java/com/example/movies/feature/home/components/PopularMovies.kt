package com.example.movies.feature.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.examle.movies.core.ui.components.fadeModifier
import com.example.movies.core.model.home.PopularMovie
import com.example.movies.feature.home.state.PopularMoviesState
import com.example.movies_compose.feature.home.R

@Composable
fun PopularMovies(
    modifier: Modifier = Modifier,
    onRetryClick: () -> Unit,
    title: String = stringResource(id = R.string.popular_movies_title),
    popularMoviesState: PopularMoviesState,
) {

    val context = LocalContext.current

    MovieSection(title = title, modifier = modifier) {
        when (popularMoviesState) {
            is PopularMoviesState.DataLoaded -> {
                PopularMoviesList(
                    popularMovies = popularMoviesState.data,
                    childModifier = Modifier.fadeModifier(false)
                )
            }
            is PopularMoviesState.Error -> {
                ErrorView(
                    message = popularMoviesState.errorMessage.asString(context)!!,
                    onRetryClick = onRetryClick
                )
            }
            PopularMoviesState.Loading -> {
                PopularMoviesList(
                    popularMovies = (0..10).map { PopularMovie() },
                    childModifier = Modifier.fadeModifier(true)
                )
            }
        }
    }

}