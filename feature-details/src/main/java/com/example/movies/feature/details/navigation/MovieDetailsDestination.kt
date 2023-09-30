package com.example.movies.feature.details.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.movies.core.model.moviedetails.Cast
import com.example.movies.core.navigation.MoviesNavigationDestination
import com.example.movies.core.navigation.args.moviedetails.MovieDetailsScreenArgConstants
import com.example.movies.feature.details.movie.screen.MovieDetailsScreen
import com.google.accompanist.navigation.animation.composable

object MovieDetailsDestination : MoviesNavigationDestination {
    override val route: String
        get() = Routes.MOVIE_DETAILS_ROUTE
    override val destination: String
        get() = Routes.MOVIE_DETAILS_DESTINATION
    override val scrollable: Boolean
        get() = true
    val arguments
        get() = listOf(
            navArgument(MovieDetailsScreenArgConstants.MOVIE_ID_ARG_KEY) { type = NavType.IntType })
}

fun NavGraphBuilder.movieDetailsGraph(
    onBackButtonClick: () -> Unit,
    onSeeAllButtonClickForCast: (List<Cast>) -> Unit,
) {
    composable(
        route = MovieDetailsDestination.destination + "/{${MovieDetailsScreenArgConstants.MOVIE_ID_ARG_KEY}}",
        arguments = MovieDetailsDestination.arguments
    ) {
        MovieDetailsScreen(
            onBackButtonClick = onBackButtonClick,
            onSeeAllButtonClickForCast = onSeeAllButtonClickForCast
        )
    }
}