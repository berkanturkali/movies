package com.example.movies.feature.search.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.examle.movies.core.ui.providers.LocalSearchQuery
import com.example.movies.feature.search.components.SearchCategoriesScreenEmptyView
import com.example.movies.feature.search.components.SearchGridItem
import com.example.movies.feature.search.components.searchCategoriesGrid
import com.example.movies.feature.search.viewmodel.MoviesViewModel

private const val CELL_COUNT = 2

@Composable
fun Movies(setQuery: Boolean, modifier: Modifier = Modifier) {

    val viewModel = hiltViewModel<MoviesViewModel>()

    val query = LocalSearchQuery.current

    if (setQuery) {
        viewModel.setQuery(query)
    }

    val movies = viewModel.movies.collectAsLazyPagingItems()
    if (movies.itemCount > 0) {
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Fixed(CELL_COUNT),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            searchCategoriesGrid(
                categoryItems = movies, onRetryClick = {}, cellCount = CELL_COUNT,
                shape = RoundedCornerShape(4.dp)
            ) { movie ->
                SearchGridItem(
                    image = movie?.poster,
                    name = movie?.title!!,
                    onItemClick = {

                    },
                    showPosterView = movie.poster != null
                )
            }
        }
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            SearchCategoriesScreenEmptyView()
        }
    }
}
