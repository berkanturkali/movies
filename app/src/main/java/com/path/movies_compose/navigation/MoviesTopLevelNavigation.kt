package com.path.movies_compose.navigation

import androidx.annotation.DrawableRes
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.movies_compose.feature.downloads.R.string.downloads
import com.example.movies_compose.feature.downloads.navigation.DownloadsDestination
import com.example.movies_compose.feature.home.R.string.home
import com.example.movies_compose.feature.home.navigation.HomeDestination
import com.example.movies_compose.feature.more.R.string.more
import com.example.movies_compose.feature.more.navigation.MoreDestination
import com.example.movies_compose.feature.search.R.string.search
import com.example.movies_compose.feature.search.navigation.SearchDestination
import com.example.movies_compose.feature.upcomings.R.string.coming_soon
import com.example.movies_compose.feature.upcomings.navigation.ComingSoonDestination
import com.path.movies_compose.R

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
    val iconTextId: Int
)

val TOP_LEVEL_DESTINATIONS = listOf(
    TopLevelDestination(
        route = HomeDestination.route,
        icon = R.drawable.ic_home,
        iconTextId = home
    ),
    TopLevelDestination(
        route = SearchDestination.route,
        icon = R.drawable.ic_search,
        iconTextId = search
    ),
    TopLevelDestination(
        route = ComingSoonDestination.route,
        icon = R.drawable.ic_play,
        iconTextId = coming_soon
    ),
    TopLevelDestination(
        route = DownloadsDestination.route,
        icon = R.drawable.ic_download,
        iconTextId = downloads
    ),
    TopLevelDestination(
        route = MoreDestination.route,
        icon = R.drawable.ic_more,
        iconTextId = more
    ),
)