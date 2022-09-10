package com.example.movies.feature.downloads.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.movies_compose.core.navigation.MoviesNavigationDestination
import com.example.movies_compose.feature.downloads.util.Constants.DOWNLOADS_DESTINATION
import com.example.movies_compose.feature.downloads.util.Constants.DOWNLOADS_ROUTE

object DownloadsDestination : MoviesNavigationDestination {
    override val route: String
        get() = DOWNLOADS_ROUTE
    override val destination: String
        get() = DOWNLOADS_DESTINATION
}


fun NavGraphBuilder.downloadsGraph() {
    composable(
        route = DownloadsDestination.route
    ) {
        //downloads screen
    }
}