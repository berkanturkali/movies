package com.example.movies.feature.details.movie.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movies.feature.details.R

@Composable
fun OriginalLanguage(
    language: String,
    modifier: Modifier = Modifier
) {
    SubTitleAndDescription(
        titleId = R.string.original_language_title,
        description = language,
        modifier = modifier
    )
}