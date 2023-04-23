package com.example.movies.feature.search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun RecentSearchesTitleAndClearButton(
    onClearButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        RecentSearchesTitle()
        RecentSearchesClearButton(onClearButtonClick = onClearButtonClick)
    }
}


@Preview
@Composable
fun RecentSearchesTitleAndClearButtonPrev() {
    MoviesTheme {
        RecentSearchesTitleAndClearButton(onClearButtonClick = {})
    }
}