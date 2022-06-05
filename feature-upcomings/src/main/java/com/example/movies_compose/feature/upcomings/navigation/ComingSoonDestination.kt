package com.example.movies_compose.feature.upcomings.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.movies_compose.core.navigation.MoviesNavigationDestination
import com.example.movies_compose.feature.upcomings.util.Constants.COMING_SOON_DESTINATION
import com.example.movies_compose.feature.upcomings.util.Constants.COMING_SOON_ROUTE

object ComingSoonDestination : MoviesNavigationDestination {
    override val route: String
        get() = COMING_SOON_ROUTE
    override val destination: String
        get() = COMING_SOON_DESTINATION
}


fun NavGraphBuilder.addComingSoonGraph() {
    composable(
        route = ComingSoonDestination.route
    ) {
        //coming-soon screen
    }
}