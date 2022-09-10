package com.example.movies.feature.search.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.movies.core.navigation.MoviesNavigationDestination
import com.example.movies.feature.search.util.Constants.SEARCH_DESTINATION
import com.example.movies.feature.search.util.Constants.SEARCH_ROUTE

object SearchDestination : MoviesNavigationDestination {
    override val route: String
        get() = SEARCH_ROUTE
    override val destination: String
        get() = SEARCH_DESTINATION
}

fun NavGraphBuilder.searchGraph() {

    composable(
        route = SearchDestination.route
    ) {
        //search screen
    }
}