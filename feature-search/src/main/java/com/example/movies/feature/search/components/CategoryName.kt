package com.example.movies.feature.search.components

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

@Composable
fun CategoryName(name: String, modifier: Modifier = Modifier) {

    Text(
        modifier = modifier.fillMaxWidth(),
        text = name,
        color = MaterialTheme.colorScheme.onPrimary,
        style = MaterialTheme.typography.bodyLarge,
        maxLines = 1,
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun CategoryNamePrev() {
    CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
        MoviesTheme {
            CategoryName(name = "Category")
        }
    }
}