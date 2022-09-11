package com.example.movies.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.movies.feature.downloads.navigation.downloadsGraph
import com.example.movies.feature.home.navigation.HomeDestination
import com.example.movies.feature.home.navigation.homeGraph
import com.example.movies.feature.more.navigation.moreGraph
import com.example.movies.feature.search.navigation.searchGraph
import com.example.movies.feature.upcomings.navigation.comingSoonGraph

@Composable
fun MoviesNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
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

        //coming-soon graph
        comingSoonGraph()

        //downloads graph
        downloadsGraph()

        //more graph
        moreGraph()
    }
}