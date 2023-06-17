package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun MovieStatus(
    status: String?,
    modifier: Modifier = Modifier
) {
    status?.let {
        Box(
            modifier = modifier.border(
                1.dp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                shape = RoundedCornerShape(4.dp)
            ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = status,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                modifier = Modifier.padding(vertical = 1.dp, horizontal = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun MovieStatusPrev() {
    MoviesTheme {
        MovieStatus(status = "R")
    }
}