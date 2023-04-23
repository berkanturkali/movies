package com.example.movies.feature.search.screen

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.examle.movies.core.ui.providers.LocalSearchQuery
import com.example.movies.feature.search.components.SearchGridItem
import com.example.movies.feature.search.components.SearchItem
import com.example.movies.feature.search.components.searchCategoriesGrid
import com.example.movies.feature.search.viewmodel.MoviesViewModel

@Composable
fun Movies(modifier: Modifier = Modifier) {

    val viewModel = hiltViewModel<MoviesViewModel>()

    val query = LocalSearchQuery.current

    viewModel.setQuery(query)

    val movies = viewModel.movies.collectAsLazyPagingItems()

    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = modifier) {
        searchCategoriesGrid(categoryItems = movies, onRetryClick = {}) { movie ->
            movie?.title?.let {
                SearchGridItem(
                    image = movie.poster,
                    name = movie.title!!,
                    onItemClick = {

                    })
            }
        }
    }

}