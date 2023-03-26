package com.example.movies.feature.search.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.components.MoviesScaffold
import com.examle.movies.core.ui.icon.MoviesIcons
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.core.model.search.SearchCategory
import com.example.movies.feature.search.components.CategoryItem


@Composable
fun SearchCategoriesScreen(
    onItemClick: (SearchCategory) -> Unit,
    modifier: Modifier = Modifier
) {

    MoviesScaffold(modifier = modifier, bottomBar = {
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Icon(
                painter = painterResource(id = MoviesIcons.CLOSE),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }) {
        SearchCategoriesContent(onItemClick = onItemClick)
    }
}

@Composable
private fun SearchCategoriesContent(
    onItemClick: (SearchCategory) -> Unit,
    modifier: Modifier = Modifier
) {

    val categories = SearchCategory.values()
        .toList()
    LazyColumn(
        modifier = modifier, verticalArrangement = Arrangement.spacedBy(40.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(categories) { searchCategory ->
            CategoryItem(category = searchCategory, onItemClick = onItemClick)
        }
    }
}

@Preview
@Composable
fun SearchCategoriesContentPrev() {
    CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
        MoviesTheme {
            SearchCategoriesContent(onItemClick = {})
        }
    }
}

