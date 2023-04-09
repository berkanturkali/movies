package com.example.movies.feature.search.components

import androidx.compose.material.Tab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.movies.core.model.search.SearchCategory

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
    ScrollableTabRow(
        selectedTabIndex = selectedIndex, indicator = indicator, modifier = modifier
    ) {
        categories.forEachIndexed { index, searchCategory ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onCategorySelected(searchCategory) },
                text = {
                    Text(
                        text = stringResource(id = searchCategory.categoryResId),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                })
        }
    }
}