package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movies.feature.details.common.components.ScoreView

@Composable
fun DetailsHeader(
    title: String?,
    date: String?,
    status: String?,
    imageUrl: String?,
    score:Float,
    genres: List<String>?,
    modifier: Modifier = Modifier
) {

    Row(modifier = modifier.fillMaxWidth()) {
        MoviePoster(imageUrl = imageUrl)
        Column {
            Title(title = title, year = date)
            Row {
                MovieStatus(status = status)
                DateAndGenres(date = date, genres = genres)
            }
            ScoreView(score = score)
        }
    }

}