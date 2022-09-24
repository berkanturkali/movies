package com.example.movies.feature.home.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.examle.movies.core.ui.components.MoviesScaffold
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.example.movies.feature.home.components.*
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun HomeScreen() {

    MoviesScaffold(
        topBar = {
            HomeScreenAppBar()
        }
    ) {
        val list = (0..20).map { it.toString() }
        Home(
            trendingMovies = list,
            nowPlayingMovies = list,
            upcomingMovies = list,
            popularMovies = list,
            topRatedMovies = list
        )
    }
}

@Composable
private fun Home(
    modifier: Modifier = Modifier,
    loading: Boolean = false,
    trendingMovies: List<String>,
    nowPlayingMovies: List<String>,
    upcomingMovies: List<String>,
    popularMovies: List<String>,
    topRatedMovies: List<String>,
) {

    val windowWidthSizeClass = LocalWindowWidthSizeClass.current

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = loading),
        onRefresh = { /*TODO*/ }) {
        LazyColumn(modifier = modifier) {

            //highlighted movie
            item {
                if (windowWidthSizeClass == WindowWidthSizeClass.Compact || windowWidthSizeClass == WindowWidthSizeClass.Medium) {
                    HighlightedMovie(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .fillParentMaxHeight(0.7f)
                    )
                } else {
                    HighlightedMovieExpanded(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .fillParentMaxHeight(0.7f)
                    )
                }
            }

            //trending movies
            item {
                TrendingMovies(trendingMovies = trendingMovies, isLoading = false)
            }

            //now playing movies
            item {
                NowPlayingMovies(
                    isLoading = false, nowPlayingMovies = nowPlayingMovies
                )
            }

            //upcoming movies
            item {
                UpcomingMovies(upcomingMovies = upcomingMovies, isLoading = false)
            }

            //popular movies
            item {
                PopularMovies(popularMovies = popularMovies, isLoading = false)
            }

            //top rated movies
            item {
                TopRatedMovies(topRatedMovies = topRatedMovies, isLoading = false)
            }
        }
    }
}