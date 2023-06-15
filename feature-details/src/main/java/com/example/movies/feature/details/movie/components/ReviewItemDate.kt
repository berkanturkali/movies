package com.example.movies.feature.details.movie.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun ReviewItemDate(
    date: String?,
    modifier: Modifier = Modifier
) {
    date?.let {
        Text(
            text = date, modifier = modifier,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
        )
    }
}

@Preview
@Composable
fun ReviewItemDatePrev() {
    MoviesTheme {
        ReviewItemDate(date = "August 13,2022")
    }
}