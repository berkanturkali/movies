package com.example.movies.feature.details.movie.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movies.feature.details.R

@Composable
fun Status(
    description: String,
    modifier: Modifier = Modifier,
) {
    SubTitleAndDescription(
        modifier = modifier,
        titleId = R.string.status_title,
        description = description
    )
}