package com.example.movies.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
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
import com.examle.movies.core.ui.components.MoviesBackground
import com.examle.movies.core.ui.components.MoviesDivider
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.navigation.MoviesNavHost
import com.example.movies.navigation.MoviesTopLevelNavigation
import com.example.movies.navigation.TOP_LEVEL_DESTINATIONS
import com.example.movies.navigation.TopLevelDestination
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.squareup.moshi.Moshi

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MoviesApp(
    moshi: Moshi,
    modifier: Modifier = Modifier
) {
    val windowWidthSizeClass = LocalWindowWidthSizeClass.current
    MoviesTheme(windowWidthSizeClass = windowWidthSizeClass) {
        val navController = rememberAnimatedNavController()
        val moviesTopLevelNavigation = remember(navController) {
            MoviesTopLevelNavigation(navController)
        }
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        val topLevelDestinationRoutes = TOP_LEVEL_DESTINATIONS.map { it.route }

        val isNavbarVisible = navBackStackEntry?.destination?.route in topLevelDestinationRoutes

        MoviesBackground {
            Scaffold(
                modifier = modifier,
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground,
                bottomBar = {
                    if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
                        if (isNavbarVisible) {
                            Column {
                                MoviesDivider()
                                MoviesBottomBar(
                                    onNavigateToTopLevelDestination = moviesTopLevelNavigation::navigateTo,
                                    scrollToTopForCurrentDestination = {

                                    },
                                    currentDestination = currentDestination
                                )
                            }
                        }
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
                    if (windowWidthSizeClass != WindowWidthSizeClass.Compact) {
                        MoviesNavRail(
                            onNavigateToTopLevelDestination = moviesTopLevelNavigation::navigateTo,
                            currentDestination = currentDestination,
                            modifier = Modifier.safeDrawingPadding()
                        )
                    }
                    MoviesNavHost(
                        moshi = moshi,
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
    scrollToTopForCurrentDestination: () -> Unit,
    currentDestination: NavDestination?,
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
                    onClick = {
                        if (selected) {
                            if (destination.scrollable) {
                                scrollToTopForCurrentDestination()
                            }
                        } else {
                            onNavigateToTopLevelDestination(destination)
                        }
                    },
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