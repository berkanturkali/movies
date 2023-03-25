package com.example.movies.feature.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.examle.movies.core.ui.components.fadeModifier
import com.example.movies.core.model.home.TopRatedMovie
import com.example.movies.feature.home.state.TopRatedMoviesState
import com.example.movies_compose.feature.home.R

@Composable
fun TopRatedMovies(
    topRatedMoviesState: TopRatedMoviesState,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.top_rated_movies_title),
    ) {

    val context = LocalContext.current
    MovieSection(title = title, modifier = modifier) {
        when (topRatedMoviesState) {
            is TopRatedMoviesState.Error -> {
                ErrorView(
                    message = topRatedMoviesState.errorMessage.asString(context)!!,
                    onRetryClick = onRetryClick
                )
            }
            TopRatedMoviesState.Loading -> {
                TopRatedMoviesList(
                    topRatedMovies = (0..10).map { TopRatedMovie() },
                    childModifier = Modifier.fadeModifier(true)
                )
            }
            is TopRatedMoviesState.TopRatedMovies -> {
                TopRatedMoviesList(
                    topRatedMovies = topRatedMoviesState.data,
                    childModifier = Modifier.fadeModifier(false)
                )
            }
        }

    }

}