package com.example.movies.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.movies.feature.details.navigation.MovieDetailsDestination
import com.example.movies.feature.details.navigation.movieDetailsGraph
import com.example.movies.feature.home.navigation.HomeDestination
import com.example.movies.feature.home.navigation.homeGraph
import com.example.movies.feature.search.navigation.SearchCategoriesDestination
import com.example.movies.feature.search.navigation.searchGraph
import com.google.accompanist.navigation.animation.AnimatedNavHost
import timber.log.Timber

@Composable
fun MoviesNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = HomeDestination.route

) {
    AnimatedNavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        //home graph
        homeGraph { id ->
            Timber.d("here")
            navController.navigate(MovieDetailsDestination.destination + "/$id")
        }

        //search graph
        searchGraph(
            onBackButtonClick = {
                navController.navigateUp()
            },
            navigateToSearchCategoriesScreen = { query ->
                navController.navigate(SearchCategoriesDestination.route + "/$query")
            })

        //movie details
        movieDetailsGraph(onBackButtonClick = {
            navController.navigateUp()
        })
    }
}