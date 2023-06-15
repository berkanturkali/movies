package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.components.MoviesSurface
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun ReviewItemRating(
    backgroundColor: Color,
    rating: String,
    modifier: Modifier = Modifier
) {
    MoviesSurface(
        modifier = modifier,
        shape = RoundedCornerShape(4.dp),
        color = backgroundColor
    ) {
        Text(
            text = "$rating/10",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 8.dp)
        )
    }
}

@Preview
@Composable
fun ReviewItemRatingPrev() {
    MoviesTheme {
        ReviewItemRating(backgroundColor = Color.Green.copy(alpha = 0.8f), rating = "8")
    }
}