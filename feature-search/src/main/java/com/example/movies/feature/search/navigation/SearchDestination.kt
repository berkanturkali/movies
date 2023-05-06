package com.example.movies.feature.search.navigation

import androidx.compose.animation.fadeIn
import androidx.navigation.NavGraphBuilder

import com.example.movies.core.navigation.MoviesNavigationDestination
import com.example.movies.feature.search.screen.SearchScreen
import com.example.movies.feature.search.util.Constants.SEARCH_DESTINATION
import com.example.movies.feature.search.util.Constants.SEARCH_ROUTE
import com.google.accompanist.navigation.animation.composable

object SearchDestination : MoviesNavigationDestination {
    override val route: String
        get() = SEARCH_ROUTE
    override val destination: String
        get() = SEARCH_DESTINATION
    override val scrollable: Boolean
        get() = true
}

fun NavGraphBuilder.searchGraph(
    onBackButtonClick:() -> Unit,
    navigateToSearchCategoriesScreen: (String) -> Unit,
) {

    composable(
        route = SearchDestination.route,
        popEnterTransition = { fadeIn() }

    ) {
        //search screen
        SearchScreen(navigateToSearchCategoriesScreen = navigateToSearchCategoriesScreen)
    }

    searchCategories(onBackButtonClick = onBackButtonClick)
}