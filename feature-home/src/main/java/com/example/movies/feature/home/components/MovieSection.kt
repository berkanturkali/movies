package com.example.movies.feature.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource

@Composable
fun MovieSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {},
) {
    Column(
        modifier = modifier.padding(
            horizontal = dimensionResource(id = com.examle.movies.core.ui.R.dimen.dimen_8)
        )
    ) {
        SectionTitle(title = title)
        content.invoke()
    }
}