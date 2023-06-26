package com.example.movies.feature.details.movie.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Revenue(
    revenue: String?,
    modifier: Modifier = Modifier
) {
    revenue?.let {
        Text(
            modifier = modifier,
            text = revenue,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodySmall
        )
    }
}