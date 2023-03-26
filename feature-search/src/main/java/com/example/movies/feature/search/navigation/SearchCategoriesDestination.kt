package com.example.movies.feature.search.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.movies.core.navigation.MoviesNavigationDestination
import com.example.movies.feature.search.screen.SearchCategoriesScreen
import com.example.movies.feature.search.util.Constants

object SearchCategoriesDestination : MoviesNavigationDestination {
    override val route: String
        get() = Constants.SEARCH_CATEGORIES_ROUTE
    override val destination: String
        get() = Constants.SEARCH_CATEGORIES_DESTINATION
    override val scrollable: Boolean
        get() = true

}

fun NavGraphBuilder.searchCategories() {

    composable(route = SearchCategoriesDestination.route) {
        SearchCategoriesScreen(onItemClick = {})
    }
}