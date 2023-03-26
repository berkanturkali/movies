package com.example.movies.feature.search.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.core.model.search.SearchCategory

@Composable
fun CategoryItem(
    category: SearchCategory,
    onItemClick: (SearchCategory) -> Unit,
    modifier: Modifier = Modifier
) {

    Text(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(category)
            },
        text = category.name,
        color = MaterialTheme.colorScheme.onPrimary,
        style = MaterialTheme.typography.bodyLarge,
        maxLines = 1,
        textAlign = TextAlign.Center,
    )
}

@Preview
@Composable
fun CategoryItemPrev() {
    CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
        MoviesTheme {
            CategoryItem(category = SearchCategory.COLLECTIONS, onItemClick = {})
        }
    }
}