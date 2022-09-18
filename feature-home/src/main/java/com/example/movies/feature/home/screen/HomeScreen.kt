package com.example.movies.feature.home.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.components.MoviesSurface
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.feature.home.components.*

@Composable
fun HomeScreen() {

    MoviesSurface {
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
    trendingMovies: List<String>,
    nowPlayingMovies: List<String>,
    upcomingMovies: List<String>,
    popularMovies: List<String>,
    topRatedMovies: List<String>,
) {

    val windowWidthSizeClass = LocalWindowWidthSizeClass.current

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


@Preview
@Composable
fun HomePrev(
) {
    CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
        MoviesTheme {
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
}