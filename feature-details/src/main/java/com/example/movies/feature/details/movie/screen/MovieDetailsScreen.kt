package com.example.movies.feature.details.movie.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.examle.movies.core.ui.components.MoviesErrorView
import com.examle.movies.core.ui.components.MoviesProgressBar
import com.examle.movies.core.ui.components.MoviesScaffold
import com.examle.movies.core.ui.utils.rememberDominantColorState
import com.example.movies.core.common.Resource
import com.example.movies.feature.details.movie.components.*
import com.example.movies.feature.details.movie.viewmodel.MovieDetailsScreenViewModel
import kotlinx.coroutines.launch
import timber.log.Timber

@Composable
fun MovieDetailsScreen(
    onBackButtonClick: () -> Unit,
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

    val listState = rememberLazyListState()

    val liked by viewModel.liked.observeAsState()

    val showStickyTopBar by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 0
        }
    }

    val coroutineScope = rememberCoroutineScope()

    MoviesScaffold(
        modifier = modifier
            .fillMaxSize(),
    ) {

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
                    MoviesProgressBar(modifier = Modifier.fillMaxSize())
                }
                is Resource.Success -> {
                    val movie = it.data
                    movie?.let {
                        val dominantColorState = rememberDominantColorState()

                        val dominantColor by animateColorAsState(
                            targetValue = dominantColorState.color,
                            spring(stiffness = Spring.StiffnessLow)
                        )

                        LaunchedEffect(key1 = true) {
                            dominantColorState.updateColorsFromImageUrl(
                                it.image ?: ""
                            )
                        }
                        Box(modifier = modifier.fillMaxSize()) {
                            Column {
                                MovieDetailsTopBar(
                                    liked = liked ?: false,
                                    onBackButtonClick = onBackButtonClick,
                                    onFavButtonClick = { liked ->
                                        if (movie.id != null) {
                                            viewModel.setLiked(liked)
                                            if (liked) {
                                                viewModel.addMovieToFavorites(movie)
                                            } else {
                                                viewModel.removeMovieFromFavorites(movie)
                                            }
                                        }
                                    }
                                )

                                LazyColumn(
                                    state = listState,
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.spacedBy(12.dp)
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
                                        dominantColor = dominantColor,
                                        scoreColor = viewModel.calculateColorCodeFromScore(
                                            movie.score
                                        ),
                                    )

                                    cast?.let { castResource ->
                                        movieDetailsItem(
                                            context = context,
                                            resource = castResource,
                                            onRetryClick = {
                                                viewModel.fetchCast()
                                            }) { castList ->
                                            Cast(
                                                cast = castList.filterNotNull()
                                            )
                                        }

                                    }

                                    recommendations?.let { recommendationsResource ->
                                        movieDetailsItem(
                                            context = context, resource = recommendationsResource,
                                            onRetryClick = viewModel::fetchRecommendations
                                        ) { recommendationsList ->
                                            if (recommendationsList.isNotEmpty()) {
                                                Recommendations(
                                                    recommendations = recommendationsList.take(10),
                                                    scoreColor = viewModel.calculateColorCodeFromScore(
                                                        movie.score
                                                    ),
                                                    onItemClick = {

                                                    }
                                                )
                                            }
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

                                    videos?.let { videosResource ->
                                        movieDetailsItem(
                                            context = context,
                                            resource = videosResource,
                                            onRetryClick = viewModel::fetchVideos
                                        ) { videos ->
                                            Videos(
                                                videos = videos,
                                                onVideoClick = { url ->

                                                })
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
                                }
                            }

                            //sticky topbar
                            AnimatedVisibility(
                                visible = showStickyTopBar,
                                enter = expandVertically(),
                                exit = shrinkVertically()
                            ) {
                                MovieDetailsStickyTopBar(
                                    image = movie.image, title = movie.title,
                                    dominantColor = dominantColor,
                                    onTopBarClick = {
                                        coroutineScope.launch {
                                            listState.animateScrollToItem(index = 0)
                                        }
                                    },
                                    liked = liked ?: false,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}