package com.example.movies.feature.home.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.examle.movies.core.ui.components.MoviesErrorView
import com.examle.movies.core.ui.components.fadeModifier
import com.example.movies.core.model.home.NowPlayingMovie
import com.example.movies.feature.home.state.NowPlayingMoviesState
import com.example.movies_compose.feature.home.R

@Composable
fun NowPlayingMovies(
    nowPlayingMoviesState: NowPlayingMoviesState,
    onRetryClick: () -> Unit,
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.now_playing_movies_title),
) {
    val context = LocalContext.current

    MovieSection(title = title, modifier = modifier) {
        when (nowPlayingMoviesState) {
            is NowPlayingMoviesState.DataLoaded -> {
                NowPlayingMoviesList(
                    childModifier = Modifier.fadeModifier(false),
                    nowPlayingMovies = nowPlayingMoviesState.data
                )
            }
            is NowPlayingMoviesState.Error -> {
                MoviesErrorView(
                    message = nowPlayingMoviesState.errorMessage.asString(context)!!,
                    onRetryClick = onRetryClick
                )
            }
            NowPlayingMoviesState.Loading -> {
                NowPlayingMoviesList(
                    childModifier = Modifier.fadeModifier(false),
                    nowPlayingMovies = (0..10).map { NowPlayingMovie() }
                )
            }
        }
    }
}