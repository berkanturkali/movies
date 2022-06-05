package com.example.movies_compose.feature.more.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.movies_compose.core.navigation.MoviesNavigationDestination
import com.example.movies_compose.feature.more.utils.Constants.MORE_DESTINATION
import com.example.movies_compose.feature.more.utils.Constants.MORE_ROUTE

object MoreDestination : MoviesNavigationDestination {
    override val route: String
        get() = MORE_ROUTE
    override val destination: String
        get() = MORE_DESTINATION
}


fun NavGraphBuilder.addMoreGraph() {
    composable(
        route = MoreDestination.route
    ) {
        //more screen
    }
}