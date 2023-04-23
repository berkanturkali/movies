package com.example.movies.feature.search.screen

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.examle.movies.core.ui.providers.LocalSearchQuery
import com.example.movies.feature.search.components.SearchGridItem
import com.example.movies.feature.search.components.searchCategoriesGrid
import com.example.movies.feature.search.viewmodel.PeopleViewModel

@Composable
fun People(modifier: Modifier = Modifier) {


    val viewModel = hiltViewModel<PeopleViewModel>()

    val query = LocalSearchQuery.current

    viewModel.setQuery(query)

    val people = viewModel.people.collectAsLazyPagingItems()

    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = modifier) {
        searchCategoriesGrid(categoryItems = people, onRetryClick = {}) { person ->
            person?.name?.let {
                SearchGridItem(
                    image = person.path,
                    name = person.name!!,
                    shape = CircleShape,
                    onItemClick = {

                    }
                )
            }
        }
    }

}