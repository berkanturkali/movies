package com.example.movies.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.movies.feature.home.navigation.HomeDestination
import com.example.movies.feature.home.navigation.homeGraph
import com.example.movies.feature.search.navigation.SearchCategoriesDestination
import com.example.movies.feature.search.navigation.searchGraph
import com.google.accompanist.navigation.animation.AnimatedNavHost

@Composable
fun MoviesNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = HomeDestination.route

) {
    AnimatedNavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        //home graph
        homeGraph()

        //search graph
        searchGraph(
            onBackButtonClick = {
                navController.navigateUp()
            },
            navigateToSearchCategoriesScreen = { query ->
                navController.navigate(SearchCategoriesDestination.route + "/$query")
            })
    }
}