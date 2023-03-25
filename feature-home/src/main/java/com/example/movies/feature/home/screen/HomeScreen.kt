package com.example.movies.feature.home.screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.examle.movies.core.ui.components.MoviesScaffold
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.example.movies.core.common.UiText
import com.example.movies.feature.home.components.*
import com.example.movies.feature.home.state.*
import com.example.movies.feature.home.util.rememberDominantColorState
import com.example.movies.feature.home.viewmodel.HomeScreenViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {

    val trendingMoviesState by viewModel.topTrendingMoviesState.collectAsState()

    val nowPlayingMoviesState by viewModel.nowPlayingMoviesState.collectAsState()

    val upcomingMoviesState by viewModel.upcomingMoviesState.collectAsState()

    val popularMoviesState by viewModel.popularMoviesState.collectAsState()

    val topRatedMoviesState by viewModel.topRatedMoviesState.collectAsState()

    val loading by viewModel.loading.collectAsState(false)

    val error by viewModel.error.collectAsState(null)

    val scaffoldState = rememberScaffoldState()

    MoviesScaffold(
        modifier = modifier,
        topBar = {
            HomeScreenAppBar()
        },
        scaffoldState = scaffoldState
    ) {
        Home(
            loading = loading,
            error = error,
            trendingMoviesState = trendingMoviesState,
            nowPlayingMoviesState = nowPlayingMoviesState,
            upcomingMoviesState = upcomingMoviesState,
            popularMoviesState = popularMoviesState,
            topRatedMoviesState = topRatedMoviesState,
            onRefresh = viewModel::fetchAllMovies
        )
    }
}

@Composable
private fun Home(
    error: UiText?,
    trendingMoviesState: TrendingMoviesState,
    nowPlayingMoviesState: NowPlayingMoviesState,
    upcomingMoviesState: UpcomingMoviesState,
    popularMoviesState: PopularMoviesState,
    topRatedMoviesState: TopRatedMoviesState,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
    loading: Boolean = false,

    ) {

    val windowWidthSizeClass = LocalWindowWidthSizeClass.current

    val context = LocalContext.current

    val dominantColorState = rememberDominantColorState()

    val dominantColor by animateColorAsState(
        targetValue = dominantColorState.color,
        spring(stiffness = Spring.StiffnessLow)
    )


    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = loading),
        onRefresh = {
            onRefresh()
        }) {
        LazyColumn(modifier = modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {

            if (error != null) {
                error.asString(context)
                    ?.let { message ->
                        item {
                            ErrorView(
                                modifier = Modifier
                                    .fillParentMaxWidth()
                                    .wrapContentHeight(),
                                message = message,
                                onRetryClick = onRefresh
                            )
                        }
                    }
            } else {
                //highlighted movie
                item {
                    when (topRatedMoviesState) {
                        is TopRatedMoviesState.Error -> {

                        }
                        TopRatedMoviesState.Loading -> {
                            HighlightedMovieShimmer(
                                modifier = Modifier
                                    .fillParentMaxWidth()
                                    .fillParentMaxHeight(0.7f)
                            )
                        }
                        is TopRatedMoviesState.TopRatedMovies -> {
                            if (windowWidthSizeClass == WindowWidthSizeClass.Compact || windowWidthSizeClass == WindowWidthSizeClass.Medium) {
                                LaunchedEffect(key1 = true) {
                                    dominantColorState.updateColorsFromImageUrl(
                                        topRatedMoviesState.data[0].image ?: ""
                                    )
                                }
                                HighlightedMovie(
                                    modifier = Modifier
                                        .fillParentMaxWidth()
                                        .fillParentMaxHeight(0.7f),
                                    image = topRatedMoviesState.data[0].image ?: "",
                                    dominantColor = dominantColor
                                )
                            } else {
                                HighlightedMovieExpanded(
                                    modifier = Modifier
                                        .fillParentMaxWidth()
                                        .fillParentMaxHeight(0.7f)
                                )
                            }
                        }
                    }
                }

                //trending movies
                item {
                    TrendingMovies(
                        trendingMoviesState = trendingMoviesState, onRetryClick = onRefresh
                    )
                }

                //now playing movies
                item {
                    NowPlayingMovies(
                        nowPlayingMoviesState = nowPlayingMoviesState,
                        onRetryClick = onRefresh
                    )
                }

//            //upcoming movies
                item {
                    UpcomingMovies(
                        upcomingMoviesState = upcomingMoviesState,
                        onRetryClick = onRefresh
                    )
                }

//            //popular movies
                item {
                    PopularMovies(
                        popularMoviesState = popularMoviesState,
                        onRetryClick = onRefresh
                    )
                }

//            //top rated movies
                item {
                    TopRatedMovies(
                        topRatedMoviesState = topRatedMoviesState,
                        onRetryClick = onRefresh
                    )
                }
            }
        }
    }
}