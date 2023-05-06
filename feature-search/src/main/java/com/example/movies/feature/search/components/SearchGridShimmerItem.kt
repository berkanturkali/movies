package com.example.movies.feature.search.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.components.shimmerModifier
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun SearchGridShimmerItem(
    shape: RoundedCornerShape,
    modifier: Modifier = Modifier
) {

    val heightModifier: Modifier = if (shape == CircleShape) {
        Modifier.aspectRatio(1f)
    } else {
        when (LocalWindowWidthSizeClass.current) {
            WindowWidthSizeClass.Compact -> Modifier
                .height(220.dp)
            WindowWidthSizeClass.Medium -> Modifier
                .height(290.dp)
            WindowWidthSizeClass.Compact -> Modifier
                .height(360.dp)
            else -> Modifier
                .height(220.dp)
        }
    }
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .then(heightModifier)
                .clip(shape)
                .shimmerModifier()
        )
    }
}

@Preview
@Composable
fun SearchGridShimmerItemPrev() {
    MoviesTheme {
        CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
            SearchGridShimmerItem(shape = CircleShape)
        }
    }
}