package com.example.movies.feature.search.screen

import androidx.compose.material.Tab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.components.MoviesScaffold
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.core.model.search.SearchCategory
import com.example.movies.feature.search.components.SearchCategoryTabIndicator


@Composable
fun SearchCategoriesScreen(
    onItemClick: (SearchCategory) -> Unit,
    modifier: Modifier = Modifier
) {

    MoviesScaffold(modifier = modifier) {

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

@Composable
fun SearchCategoryTabs(
    categories: List<SearchCategory>,
    selectedCategory: SearchCategory,
    onCategorySelected: (SearchCategory) -> Unit,
    modifier: Modifier = Modifier
) {

    val selectedIndex = categories.indexOfFirst { it == selectedCategory }
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        SearchCategoryTabIndicator(
            modifier = Modifier.tabIndicatorOffset(tabPositions[selectedIndex])
        )
    }
    TabRow(
        selectedTabIndex = selectedIndex,
        indicator = indicator,
        modifier = modifier
    ) {
        categories.forEachIndexed { index, searchCategory ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onCategorySelected(searchCategory) },
                text = {
                    Text(
                        text = stringResource(id = searchCategory.categoryResId),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun SearchCategoriesContentPrev() {
    CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
        MoviesTheme {
            SearchCategoriesContent(onItemClick = {}, selectedCategory = SearchCategory.COLLECTIONS)
        }
    }
}

