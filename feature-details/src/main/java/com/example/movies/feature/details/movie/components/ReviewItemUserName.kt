package com.example.movies.feature.details.movie.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun ReviewItemUserName(
    name: String?,
    modifier: Modifier = Modifier
) {
    name?.let {
        Text(
            modifier = modifier,
            text = name,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview
@Composable
fun ReviewItemUserNamePrev() {
    MoviesTheme {
        ReviewItemUserName(name = "MovieGuys")
    }
}