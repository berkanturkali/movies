package com.example.movies.feature.search.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.components.MoviesScaffold
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.core.model.search.SearchCategory
import com.example.movies.feature.search.components.SearchCategoryTabs


@Composable
fun SearchCategoriesScreen(
    modifier: Modifier = Modifier
) {
    val selectedCategory = rememberSaveable {
        mutableStateOf(SearchCategory.COMPANIES)
    }

    MoviesScaffold(modifier = modifier) {
        SearchCategoriesContent(
            onItemClick = { searchCategory ->
                selectedCategory.value = searchCategory
            },
            selectedCategory = selectedCategory.value
        )

        when (selectedCategory.value) {
            SearchCategory.COMPANIES -> {

            }
            SearchCategory.COLLECTIONS -> {

            }
            SearchCategory.MOVIES -> {

            }
            SearchCategory.PEOPLE -> {

            }
            SearchCategory.SHOWS -> {

            }
        }
    }
}

@Composable
private fun SearchCategoriesContent(
    onItemClick: (SearchCategory) -> Unit,
    selectedCategory: SearchCategory,
    modifier: Modifier = Modifier
) {
    val categories = SearchCategory.values()
        .toList()

    SearchCategoryTabs(
        modifier = modifier,
        categories = categories,
        onCategorySelected = onItemClick,
        selectedCategory = selectedCategory
    )
}

@Preview
@Composable
fun SearchCategoriesContentPrev() {
    MoviesTheme {
        SearchCategoriesContent(onItemClick = {}, selectedCategory = SearchCategory.COMPANIES)
    }
}

