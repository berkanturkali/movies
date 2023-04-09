package com.example.movies.feature.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.icon.MoviesIcons
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun RecentSearchesClearButton(
    onClearButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClearButtonClick,
        modifier = modifier
            .background(
                shape = CircleShape, color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.4f)
            )
            .size(20.dp)
    ) {
        Icon(
            painter = painterResource(MoviesIcons.CLEAR),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview
@Composable
fun RecentSearchesClearButtonPrev() {
    MoviesTheme {
        RecentSearchesClearButton(onClearButtonClick = { /*TODO*/ })
    }
}