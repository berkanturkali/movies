package com.example.movies.navigation

import androidx.annotation.DrawableRes
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.movies.feature.downloads.navigation.DownloadsDestination
import com.example.movies.feature.home.navigation.HomeDestination
import com.example.movies.feature.more.navigation.MoreDestination
import com.example.movies.feature.search.navigation.SearchDestination
import com.example.movies.feature.upcomings.navigation.ComingSoonDestination
import com.example.movies_compose.R
import com.example.movies_compose.feature.downloads.R.string.downloads
import com.example.movies_compose.feature.home.R.string.home
import com.example.movies_compose.feature.more.R.string.more
import com.example.movies_compose.feature.search.R.string.search
import com.example.movies_compose.feature.upcomings.R.string.coming_soon

class MoviesTopLevelNavigation(private val navController: NavHostController) {

    fun navigateTo(destination: TopLevelDestination) {
        navController.navigate(destination.route) {

            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true

            restoreState = true
        }

    }
}


data class TopLevelDestination(
    val route: String,
    @DrawableRes val icon: Int,
    val iconTextId: Int,
    val scrollable: Boolean,
)

val TOP_LEVEL_DESTINATIONS = listOf(
    TopLevelDestination(
        route = HomeDestination.route,
        icon = R.drawable.ic_home,
        iconTextId = home,
        scrollable = HomeDestination.scrollable

    ),
    TopLevelDestination(
        route = SearchDestination.route,
        icon = R.drawable.ic_search,
        iconTextId = search,
        scrollable = SearchDestination.scrollable
    ),
    TopLevelDestination(
        route = ComingSoonDestination.route,
        icon = R.drawable.ic_play,
        iconTextId = coming_soon,
        scrollable = ComingSoonDestination.scrollable
    ),
    TopLevelDestination(
        route = DownloadsDestination.route,
        icon = R.drawable.ic_download,
        iconTextId = downloads,
        scrollable = DownloadsDestination.scrollable
    ),
    TopLevelDestination(
        route = MoreDestination.route,
        icon = R.drawable.ic_more,
        iconTextId = more,
        scrollable = MoreDestination.scrollable
    ),
)