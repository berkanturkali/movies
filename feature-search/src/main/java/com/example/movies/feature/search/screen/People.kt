package com.example.movies.feature.search.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.examle.movies.core.ui.providers.LocalSearchQuery
import com.example.movies.feature.search.components.SearchCategoriesScreenEmptyView
import com.example.movies.feature.search.components.SearchGridItem
import com.example.movies.feature.search.components.searchCategoriesGrid
import com.example.movies.feature.search.viewmodel.PeopleViewModel

private const val CELL_COUNT = 3

@Composable
fun People(
    setQuery: Boolean,
    modifier: Modifier = Modifier,
    viewModel:PeopleViewModel = hiltViewModel(),
    query:String = LocalSearchQuery.current
) {
    val state = rememberLazyGridState()

    if (setQuery) {
        viewModel.setQuery(query)
    }
    val people = viewModel.people.collectAsLazyPagingItems()
    if (people.itemCount > 0) {
        LazyVerticalGrid(
            modifier = modifier,
            state = state,
            columns = GridCells.Fixed(CELL_COUNT),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            searchCategoriesGrid(
                categoryItems = people,
                onRetryClick = {},
                cellCount = CELL_COUNT,
                shape = CircleShape
            ) { person ->
                SearchGridItem(
                    image = person?.path,
                    name = person?.name!!,
                    shape = CircleShape,
                    onItemClick = {

                    }
                )
            }
        }
    } else {
        if (people.loadState.refresh is LoadState.NotLoading && people.itemCount == 0) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                SearchCategoriesScreenEmptyView()
            }
        }
    }
}
