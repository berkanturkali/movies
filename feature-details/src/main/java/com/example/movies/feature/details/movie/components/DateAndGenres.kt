package com.example.movies.feature.details.movie.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun DateAndGenres(
    date: String?,
    genres: List<String>?,
    modifier: Modifier = Modifier
) {

    val genreString = genres?.joinToString(separator = ", ")

    val list = listOf(date, genreString)

    val dateAndGenres = list.joinToString(
        "\u2022"
    )

    Text(
        modifier = modifier,
        text = dateAndGenres,
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.onSurface,
        textAlign = TextAlign.Center
    )

}

@Preview
@Composable
fun DateAndGenresPrev() {
    MoviesTheme {
        DateAndGenres(date = "05/19/2023 ", genres = listOf("Action", "Crime", "Thriller"))
    }
}