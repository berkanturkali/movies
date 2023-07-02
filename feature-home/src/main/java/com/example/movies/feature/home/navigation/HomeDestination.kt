package com.example.movies.feature.home.navigation


import androidx.navigation.NavGraphBuilder
import com.example.movies.core.navigation.MoviesNavigationDestination
import com.example.movies.feature.home.screen.HomeScreen
import com.example.movies.feature.home.util.Constants.HOME_DESTINATION
import com.example.movies.feature.home.util.Constants.HOME_ROUTE
import com.google.accompanist.navigation.animation.composable

object HomeDestination : MoviesNavigationDestination {
    override val route: String
        get() = HOME_ROUTE
    override val destination: String
        get() = HOME_DESTINATION
    override val scrollable: Boolean
        get() = true
}

fun NavGraphBuilder.homeGraph(onMovieClick: (Int) -> Unit) {
    composable(route = HomeDestination.route) { navBackStackEntry ->
        //home screen
        HomeScreen(onMovieClick = onMovieClick)
    }
}