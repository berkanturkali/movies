package com.example.movies.feature.details.movie.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun Genres(
    genres: List<String?>?,
    modifier: Modifier = Modifier
) {

    val genreString = genres?.joinToString(separator = ", ")
    genreString?.let {
        Text(
            modifier = modifier,
            text = genreString,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.End
        )
    }

}

@Preview
@Composable
fun GenresPrev() {
    MoviesTheme {
        Genres(genres = listOf("Action", "Crime", "Thriller"))
    }
}