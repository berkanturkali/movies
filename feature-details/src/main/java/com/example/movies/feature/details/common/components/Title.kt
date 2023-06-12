package com.example.movies.feature.details.common.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun Title(
    title: String,
    modifier: Modifier = Modifier
) {

    Text(
        modifier = modifier,
        text = title,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onSurface,
        maxLines = 3,
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun TitlePrev() {
    MoviesTheme {
        Title(title = "Spider-Man: Spider-Verse Collection")
    }
}