package com.example.movies.feature.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.components.fadeModifier
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun HighlightedMovieShimmer(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .padding(bottom = 18.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .fadeModifier(true)
                .fillMaxWidth(0.6f)
                .fillMaxHeight(0.15f)

        )

    }

}

@Preview
@Composable
fun HighlightedMovieShimmerPrev() {
    MoviesTheme {
        HighlightedMovieShimmer()
    }
}