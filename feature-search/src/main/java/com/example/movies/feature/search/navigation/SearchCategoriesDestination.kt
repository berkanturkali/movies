package com.example.movies.feature.search.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType


import androidx.navigation.navArgument
import com.example.movies.core.navigation.MoviesNavigationDestination
import com.example.movies.feature.search.screen.SearchCategoriesScreen
import com.example.movies.feature.search.util.Constants
import com.google.accompanist.navigation.animation.composable

object SearchCategoriesDestination : MoviesNavigationDestination {
    override val route: String
        get() = Constants.SEARCH_CATEGORIES_ROUTE
    override val destination: String
        get() = Constants.SEARCH_CATEGORIES_DESTINATION
    override val scrollable: Boolean
        get() = true

}

fun NavGraphBuilder.searchCategories(
    onBackButtonClick: () -> Unit,
) {
    composable(
        route = "${SearchCategoriesDestination.route}/{query}",
        arguments = listOf(navArgument("query") { type = NavType.StringType }),
        enterTransition = { slideInHorizontally(tween(400)) + fadeIn(tween(400)) }
    ) { navBackStackEntry ->
        SearchCategoriesScreen(onBackButtonClick = onBackButtonClick)
    }
}