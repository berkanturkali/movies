package com.example.movies.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.movies.feature.home.navigation.HomeDestination
import com.example.movies.feature.home.navigation.homeGraph
import com.example.movies.feature.search.navigation.searchGraph
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@Composable
fun MoviesNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberAnimatedNavController(),
    startDestination: String = HomeDestination.route

) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        //home graph
        homeGraph()

        //search graph
        searchGraph()
    }
}