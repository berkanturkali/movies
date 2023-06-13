package com.example.movies.feature.details.movie.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movies.feature.details.R

@Composable
fun Budget(
    budget: String,
    modifier: Modifier = Modifier
) {
    SubTitleAndDescription(
        titleId = R.string.budget_title,
        description = budget,
        modifier = modifier
    )
}