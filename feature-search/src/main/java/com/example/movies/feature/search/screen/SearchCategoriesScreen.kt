package com.example.movies.feature.search.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import com.examle.movies.core.ui.components.MoviesScaffold
import com.examle.movies.core.ui.providers.LocalSearchQuery
import com.example.movies.core.model.search.SearchCategory
import com.example.movies.feature.search.components.SearchCategoriesTopBar


@Composable
fun SearchCategoriesScreen(
    query: String,
    modifier: Modifier = Modifier
) {

    val selectedCategory = rememberSaveable {
        mutableStateOf(SearchCategory.COMPANIES)
    }

    MoviesScaffold(modifier = modifier, topBar = {
        SearchCategoriesTopBar(
            onItemClick = { searchCategory ->
                selectedCategory.value = searchCategory
            },
            selectedCategory = selectedCategory.value
        )
    }) {
        CompositionLocalProvider(LocalSearchQuery provides query) {
            when (selectedCategory.value) {
                SearchCategory.COMPANIES -> {
                    Companies()
                }
                SearchCategory.COLLECTIONS -> {
                    Collections()
                }
                SearchCategory.MOVIES -> {
                    Movies()
                }
                SearchCategory.PEOPLE -> {
                    People()
                }
                SearchCategory.SHOWS -> {
                    TvShows()
                }
            }
        }
    }
}

