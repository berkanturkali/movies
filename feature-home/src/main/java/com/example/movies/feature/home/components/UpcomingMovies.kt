package com.example.movies.feature.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.examle.movies.core.ui.components.MoviesErrorView
import com.examle.movies.core.ui.components.fadeModifier
import com.example.movies.core.model.home.UpcomingMovie
import com.example.movies.feature.home.state.UpcomingMoviesState
import com.example.movies_compose.feature.home.R

@Composable
fun UpcomingMovies(
    upcomingMoviesState: UpcomingMoviesState,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.upcoming_movies_title),
) {
    val context = LocalContext.current
    MovieSection(title = title, modifier = modifier) {
        when (upcomingMoviesState) {
            is UpcomingMoviesState.DataLoaded -> {
                UpcomingMoviesList(
                    upcomingMovies = upcomingMoviesState.data,
                    childModifier = Modifier.fadeModifier(false)
                )
            }
            is UpcomingMoviesState.Error -> {
                MoviesErrorView(
                    message = upcomingMoviesState.errorMessage.asString(context)!!,
                    onRetryClick = onRetryClick
                )
            }
            UpcomingMoviesState.Loading -> {
                UpcomingMoviesList(
                    upcomingMovies = (0..10).map { UpcomingMovie() },
                    childModifier = Modifier.fadeModifier(true)
                )
            }
        }
    }

}