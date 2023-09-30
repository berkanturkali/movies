package com.example.movies.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.feature.cast.navigation.CastDestination
import com.example.feature.cast.navigation.castGraph
import com.example.movies.core.navigation.args.cast.CastScreenArgs
import com.example.movies.feature.details.navigation.MovieDetailsDestination
import com.example.movies.feature.details.navigation.movieDetailsGraph
import com.example.movies.feature.home.navigation.HomeDestination
import com.example.movies.feature.home.navigation.homeGraph
import com.example.movies.feature.search.navigation.SearchCategoriesDestination
import com.example.movies.feature.search.navigation.searchGraph
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.squareup.moshi.Moshi

@Composable
fun MoviesNavHost(
    navController: NavHostController,
    moshi: Moshi,
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
        },
            onSeeAllButtonClickForCast = { cast ->
                val args = CastScreenArgs(castList = cast)
                val adapter = moshi.adapter(CastScreenArgs::class.java)
                try {
                    val stringifiedArgs = Uri.encode(adapter.toJson(args))
                    navController.navigate("${CastDestination.destination}/$stringifiedArgs")
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        )

        castGraph(
            onBackButtonClick = {
            navController.navigateUp()
        })
    }
}