package com.example.movies.feature.search.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.core.model.search.SearchCategory

@Composable
fun SearchCategoriesTopBar(
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
        SearchCategoriesTopBar(onItemClick = {}, selectedCategory = SearchCategory.COMPANIES)
    }
}