package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.components.fadeModifier
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun MovieDetailsFadeItem(
    modifier: Modifier = Modifier
) {

    val widthHeightModifier: Modifier = when (LocalWindowWidthSizeClass.current) {
        WindowWidthSizeClass.Compact -> Modifier
            .width(150.dp)
            .height(220.dp)
        WindowWidthSizeClass.Medium -> Modifier
            .width(220.dp)
            .height(290.dp)
        WindowWidthSizeClass.Compact -> Modifier
            .width(290.dp)
            .height(360.dp)
        else -> Modifier
            .width(150.dp)
            .height(220.dp)
    }
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .padding(end = 8.dp)
                .clip(CircleShape)
                .fadeModifier(true)

        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            repeat(10) {
                item {
                    Box(
                        modifier = widthHeightModifier
                            .clip(RoundedCornerShape(8.dp))
                            .fadeModifier(true)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MovieDetailsFadeItemPrev() {
    MoviesTheme {
        CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
            MovieDetailsFadeItem()
        }
    }
}