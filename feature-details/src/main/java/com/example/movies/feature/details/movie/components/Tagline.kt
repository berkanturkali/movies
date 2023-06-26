package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.theme.MoviesTheme

private const val ALPHA = 0.8F
@Composable
fun Tagline(
    tagline: String?,
    modifier: Modifier = Modifier
) {
    tagline?.let {
        Text(
            text = tagline,
            style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic),
            color = MaterialTheme.colorScheme.onSurface.copy(ALPHA),
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.End
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