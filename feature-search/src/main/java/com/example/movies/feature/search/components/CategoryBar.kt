package com.example.movies.feature.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies_compose.feature.search.R

@Composable
fun CategoryBar(selectedCategory: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxWidth().background(MaterialTheme.colorScheme.secondary), contentAlignment = Alignment.CenterEnd) {
        Text(
            text = String.format(
                format = stringResource(id = R.string.selected_category), selectedCategory
            ),
            style = MaterialTheme.typography.bodySmall,
            maxLines = 1,
            color = MaterialTheme.colorScheme.onPrimary,
            )
    }
}

@Preview
@Composable
fun CategoryBarPrev() {
    CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
        MoviesTheme {
            CategoryBar(selectedCategory = "Category")
        }
    }
}