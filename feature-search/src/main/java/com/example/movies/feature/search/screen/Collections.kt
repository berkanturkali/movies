package com.example.movies.feature.search.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.examle.movies.core.ui.providers.LocalSearchQuery
import com.example.movies.feature.search.components.SearchItem
import com.example.movies.feature.search.components.searchCategoriesList
import com.example.movies.feature.search.viewmodel.CollectionsViewModel

@Composable
fun Collections(
    setQuery: Boolean,
    modifier: Modifier = Modifier
) {

    val viewModel = hiltViewModel<CollectionsViewModel>()

    val query = LocalSearchQuery.current
    if (setQuery) {
        viewModel.setQuery(query)
    }
    val collections =
        viewModel.collections.collectAsLazyPagingItems()

    LazyColumn(modifier = modifier) {
        searchCategoriesList(
            categoryItems = collections,
            onRetryClick = {}) { collection ->
            SearchItem(
                image = collection?.poster,
                name = collection?.name!!,
                onItemClick = {

                })
        }
    }
}