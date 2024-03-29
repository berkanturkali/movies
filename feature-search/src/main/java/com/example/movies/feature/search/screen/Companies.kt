package com.example.movies.feature.search.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.examle.movies.core.ui.providers.LocalSearchQuery
import com.example.movies.feature.search.components.SearchItem
import com.example.movies.feature.search.components.searchCategoriesList
import com.example.movies.feature.search.viewmodel.CompaniesViewModel

@Composable
fun Companies(
    setQuery: Boolean,
    modifier: Modifier = Modifier,
    viewModel: CompaniesViewModel = hiltViewModel()
) {
    val query = LocalSearchQuery.current

    if (setQuery) {
        viewModel.setQuery(query)
    }

    val companies = viewModel.companies.collectAsLazyPagingItems()

    LazyColumn(
        modifier = modifier,
    ) {
        searchCategoriesList(
            categoryItems = companies, onRetryClick = {}) { company ->
            SearchItem(
                image = company?.logo,
                name = company?.name!!,
                onItemClick = {

                })
        }
    }
}