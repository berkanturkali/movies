package com.example.movies.feature.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.movies.core.navigation.MoviesNavigationDestination
import com.example.movies.feature.home.util.Constants.HOME_DESTINATION
import com.example.movies.feature.home.util.Constants.HOME_ROUTE

object HomeDestination : MoviesNavigationDestination {
    override val route: String
        get() = HOME_ROUTE
    override val destination: String
        get() = HOME_DESTINATION
}

fun NavGraphBuilder.homeGraph() {
    composable(route = HomeDestination.route) {
        //home screen
    }
}