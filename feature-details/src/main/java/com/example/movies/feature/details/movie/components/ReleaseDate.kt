package com.example.movies.feature.details.movie.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ReleaseDate(
    date: String?,
    modifier: Modifier = Modifier
) {
    date?.let {
        Text(
            text = date,
            modifier = modifier,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }

}