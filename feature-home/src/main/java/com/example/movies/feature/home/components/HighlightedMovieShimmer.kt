package com.example.movies.feature.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.components.MoviesSurface
import com.examle.movies.core.ui.components.fadeModifier
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
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
    CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
        MoviesTheme {
            HighlightedMovieShimmer()
        }
    }
}