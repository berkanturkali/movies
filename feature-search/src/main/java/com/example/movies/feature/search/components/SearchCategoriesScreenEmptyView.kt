package com.example.movies.feature.search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies_compose.feature.search.R

@Composable
fun SearchCategoriesScreenEmptyView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterVertically)
    ) {
        Text(
            text = stringResource(id = R.string.search_categories_empty_list_primary_message),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onPrimary,
        )
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
            Text(
                text = stringResource(id = R.string.search_categories_empty_list_secondary_message),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }
}

@Preview
@Composable
fun SearchCategoriesScreenEmptyViewPrev() {
    MoviesTheme {
        SearchCategoriesScreenEmptyView()
    }
}
