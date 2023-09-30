package com.example.feature.cast.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navArgument
import com.example.feature.cast.navigation.CastDestinationConstants.CAST_DESTINATION
import com.example.feature.cast.navigation.CastDestinationConstants.CAST_ROUTE
import com.example.feature.cast.screen.CastScreen
import com.example.movies.core.navigation.MoviesNavigationDestination
import com.example.movies.core.navigation.args.cast.CastScreenArgConstants
import com.example.movies.core.navigation.args.cast.navtype.CastScreenArgsNavType
import com.google.accompanist.navigation.animation.composable

object CastDestination : MoviesNavigationDestination {
    override val route: String
        get() = CAST_ROUTE
    override val destination: String
        get() = CAST_DESTINATION
    override val scrollable: Boolean
        get() = true
    val arguments
        get() = listOf(
            navArgument(CastScreenArgConstants.CAST_SCREEN_ARG_KEY) {
                type = CastScreenArgsNavType()
            })
}


fun NavGraphBuilder.castGraph(
    onBackButtonClick: () -> Unit,
) {
    composable(
        route = CastDestination.destination + "/{${CastScreenArgConstants.CAST_SCREEN_ARG_KEY}}",
        arguments = CastDestination.arguments,
    ) {
        CastScreen(onBackButtonClick = onBackButtonClick)
    }
}