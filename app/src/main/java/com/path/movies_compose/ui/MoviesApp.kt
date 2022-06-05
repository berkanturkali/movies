package com.path.movies_compose.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.examle.movies_compose.core.ui.theme.MoviesComposeTheme
import com.path.movies_compose.navigation.MoviesTopLevelNavigation

@Composable
fun MoviesApp(windowSizeClass: WindowSizeClass) {

    MoviesComposeTheme {
        val navController = rememberNavController()
        val moviesTopLevelNavigation = remember(navController) {
            MoviesTopLevelNavigation(navController)
        }
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
    }
}