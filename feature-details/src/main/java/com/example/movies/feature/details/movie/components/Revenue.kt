package com.example.movies.feature.details.movie.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movies.feature.details.R

@Composable
fun Revenue(
    revenue:String,
    modifier: Modifier = Modifier
) {
    SubTitleAndDescription(
        titleId = R.string.revenue_title,
        description = revenue,
        modifier = modifier
    )
}