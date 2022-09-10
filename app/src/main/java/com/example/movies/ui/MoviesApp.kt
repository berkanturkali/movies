package com.example.movies.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.examle.movies.core.ui.component.MoviesBackground
import com.examle.movies.core.ui.theme.MoviesComposeTheme
import com.example.movies.navigation.MoviesNavHost
import com.example.movies.navigation.MoviesTopLevelNavigation
import com.example.movies.navigation.TOP_LEVEL_DESTINATIONS
import com.example.movies.navigation.TopLevelDestination

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MoviesApp(windowSizeClass: WindowSizeClass) {

    MoviesComposeTheme {
        val navController = rememberNavController()
        val moviesTopLevelNavigation = remember(navController) {
            MoviesTopLevelNavigation(navController)
        }
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        MoviesBackground {
            Scaffold(
                modifier = Modifier,
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground,
                bottomBar = {
                    if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) {
                        MoviesBottomBar(
                            onNavigateToTopLevelDestination = moviesTopLevelNavigation::navigateTo,
                            currentDestination = currentDestination
                        )
                    }
                }

            ) { padding ->
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .windowInsetsPadding(
                            WindowInsets.safeDrawing.only(
                                WindowInsetsSides.Horizontal
                            )
                        )
                ) {
                    if (windowSizeClass.widthSizeClass != WindowWidthSizeClass.Compact) {
                        MoviesNavRail(
                            onNavigateToTopLevelDestination = moviesTopLevelNavigation::navigateTo,
                            currentDestination = currentDestination,
                            modifier = Modifier.safeDrawingPadding()
                        )
                    }
                    MoviesNavHost(
                        windowSizeClass = windowSizeClass,
                        navController = navController,
                        modifier = Modifier
                            .padding(padding)
                            .consumedWindowInsets(padding)
                    )
                }
            }
        }
    }
}

@Composable
private fun MoviesNavRail(
    onNavigateToTopLevelDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    NavigationRail(modifier = modifier) {
        TOP_LEVEL_DESTINATIONS.forEach { destination ->
            val selected =
                currentDestination?.hierarchy?.any { it.route == destination.route } == true
            NavigationRailItem(
                selected = selected,
                onClick = { onNavigateToTopLevelDestination(destination) },
                icon = {
                    Icon(
                        painterResource(id = destination.icon),
                        contentDescription = null
                    )
                },
                label = { Text(stringResource(destination.iconTextId)) }
            )
        }
    }
}


@Composable
private fun MoviesBottomBar(
    onNavigateToTopLevelDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?
) {
    Surface(color = MaterialTheme.colorScheme.surface) {
        NavigationBar(

            modifier = Modifier.windowInsetsPadding(
                WindowInsets.safeDrawing.only(
                    WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom
                )
            ),
            tonalElevation = 0.dp
        ) {

            TOP_LEVEL_DESTINATIONS.forEach { destination ->
                val selected =
                    currentDestination?.hierarchy?.any { it.route == destination.route } == true
                NavigationBarItem(
                    selected = selected,
                    onClick = { onNavigateToTopLevelDestination(destination) },
                    icon = {
                        Icon(
                            painter = painterResource(
                                destination.icon
                            ),
                            contentDescription = null
                        )
                    },
                )
            }
        }
    }
}