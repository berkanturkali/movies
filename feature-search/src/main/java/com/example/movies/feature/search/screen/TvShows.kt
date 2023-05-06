package com.example.movies.feature.search.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.examle.movies.core.ui.providers.LocalSearchQuery
import com.example.movies.feature.search.components.SearchItem
import com.example.movies.feature.search.components.searchCategoriesList
import com.example.movies.feature.search.viewmodel.TvShowsViewModel

@Composable
fun TvShows(
    setQuery: Boolean, modifier: Modifier = Modifier
) {

    val viewModel = hiltViewModel<TvShowsViewModel>()

    val query = LocalSearchQuery.current
    if (setQuery) {
        viewModel.setQuery(query)
    }

    val tvShows = viewModel.tvShows.collectAsLazyPagingItems()

    LazyColumn(modifier = modifier) {
        searchCategoriesList(
            categoryItems = tvShows,
            onRetryClick = {},
        ) { show ->
            SearchItem(
                image = show?.poster,
                name = show?.name!!,
                onItemClick = {

                })
        }
    }
}