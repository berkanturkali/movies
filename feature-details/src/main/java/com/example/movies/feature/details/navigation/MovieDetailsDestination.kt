package com.example.movies.feature.details.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import com.google.accompanist.navigation.animation.composable
import androidx.navigation.navArgument
import com.example.movies.core.navigation.MoviesNavigationDestination
import com.example.movies.core.navigation.args.moviedetails.MovieDetailsScreenArgs
import com.example.movies.feature.details.movie.screen.MovieDetailsScreen

object MovieDetailsDestination : MoviesNavigationDestination {
    override val route: String
        get() = Routes.MOVIE_DETAILS_ROUTE
    override val destination: String
        get() = Routes.MOVIE_DETAILS_DESTINATION
    override val scrollable: Boolean
        get() = true
    val arguments
        get() = listOf(
            navArgument(MovieDetailsScreenArgs.MOVIE_ID_ARG_KEY) { type = NavType.IntType })
}

fun NavGraphBuilder.movieDetailsGraph() {
    composable(
        route = MovieDetailsDestination.destination + "/{${MovieDetailsScreenArgs.MOVIE_ID_ARG_KEY}}",
        arguments = MovieDetailsDestination.arguments
    ) {
        MovieDetailsScreen()
    }
}