package com.example.movies.feature.details.movie.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.examle.movies.core.ui.components.MoviesErrorView
import com.examle.movies.core.ui.components.MoviesProgressBar
import com.examle.movies.core.ui.components.MoviesSurface
import com.example.movies.core.common.Resource
import com.example.movies.feature.details.movie.viewmodel.MovieDetailsScreenViewModel

@Composable
fun MovieDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: MovieDetailsScreenViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    val resource by viewModel.movie.observeAsState()

    MoviesSurface(modifier = modifier.fillMaxSize()) {

        resource?.let {
            when (resource) {
                is Resource.Error -> {
                    MoviesErrorView(
                        modifier = Modifier.fillMaxSize(),
                        message = it.error?.asString(context) ?: stringResource(
                            id = com.examle.movies.core.ui.R.string.something_went_wrong_error_message
                        ),
                        onRetryClick = {

                        }
                    )
                }
                is Resource.Loading -> {
                    MoviesProgressBar()
                }
                is Resource.Success -> {
                    val movie = it.data
                    movie?.let {
                        LazyColumn(
                            modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(6.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            movieDetailsScreenContent(
                                title = movie.title,
                                date = movie.releaseDate,
                                status = movie.status,
                                imageUrl = movie.image,
                                tagline = movie.tagLine,
                                revenue = movie.revenue,
                                overview = movie.overview,
                                score = movie.score,
                                genres = movie.genres,
                                languages = movie.languages,
                            )


                        }
                    }
                }
                null -> throw Exception(
                    "This block never reachable, since I surrounded resource with the let block"
                )
            }
        }

    }
}