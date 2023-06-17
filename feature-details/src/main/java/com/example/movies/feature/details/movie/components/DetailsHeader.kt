package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DetailsHeader(
    imageUrl: String?,
    modifier: Modifier = Modifier
) {

    Row(modifier = modifier.fillMaxWidth()) {
        MoviePoster(imageUrl = imageUrl)
        Column {

        }
    }

}