package com.example.movies.feature.details.movie.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun Tagline(
    tagline: String?,
    modifier: Modifier = Modifier
) {
    tagline?.let {
        Text(
            text = tagline,
            style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic),
            color = MaterialTheme.colorScheme.onSurface.copy(0.8f),
            modifier = modifier
        )
    }
}

@Preview
@Composable
fun TaglinePrev() {
    MoviesTheme {
        Tagline(tagline = "It's how you wear the mask that matters")
    }
}