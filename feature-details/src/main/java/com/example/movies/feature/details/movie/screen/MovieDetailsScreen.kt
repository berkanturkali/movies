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
import com.example.movies.feature.details.movie.components.*
import com.example.movies.feature.details.movie.viewmodel.MovieDetailsScreenViewModel

@Composable
fun MovieDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: MovieDetailsScreenViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    val movieResource by viewModel.movie.observeAsState()

    val cast by viewModel.cast.observeAsState()

    val reviews by viewModel.reviews.observeAsState()

    val videos by viewModel.videos.observeAsState()

    val recommendations by viewModel.recommendations.observeAsState()

    val keywords by viewModel.keywords.observeAsState()

    MoviesSurface(modifier = modifier.fillMaxSize()) {

        movieResource?.let {
            when (it) {
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
                            modifier = modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(6.dp),
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

                            cast?.let { castResource ->
                                movieDetailsItem(
                                    context = context,
                                    resource = castResource,
                                    onRetryClick = {
                                        viewModel.fetchCast()
                                    }) { castList ->
                                    Cast(cast = castList.filterNotNull())
                                }

                            }

                            recommendations?.let { recommendationsResource ->
                                movieDetailsItem(
                                    context = context, resource = recommendationsResource,
                                    onRetryClick = viewModel::fetchRecommendations
                                ) { recommendationsList ->
                                    Recommendations(recommendations = recommendationsList)
                                }
                            }

                            reviews?.let { reviewsResource ->
                                movieDetailsItem(
                                    context = context, resource = reviewsResource,
                                    onRetryClick = viewModel::fetchReviews
                                ) { reviews ->
                                    Reviews(
                                        reviews = reviews
                                    )
                                }
                            }
                            keywords?.let { keywordsResource ->
                                movieDetailsItem(
                                    context = context,
                                    resource = keywordsResource,
                                    onRetryClick = viewModel::fetchKeywords,
                                ) { keywords ->
                                    Keywords(keywords = keywords)
                                }
                            }

                            videos?.let { videosResource ->
                                movieDetailsItem(
                                    context = context,
                                    resource = videosResource,
                                    onRetryClick = viewModel::fetchVideos
                                ) { videos ->

                                }
                            }
                        }

                    }
                }
            }
        }
    }

}