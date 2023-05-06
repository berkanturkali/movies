package com.example.movies.feature.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.components.shimmerModifier
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun SearchShimmerItem(modifier: Modifier = Modifier) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(8.dp)
            .background(
                shape = RoundedCornerShape(8.dp),
                color = Color.Black
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Poster(
            image = "",
            childModifier = Modifier.shimmerModifier(),
            modifier = Modifier
                .weight(2f)
                .padding(8.dp),
        )

        Spacer(
            modifier = Modifier
                .weight(2f)
                .height(20.dp)
                .padding(end = 8.dp)
                .clip(CircleShape)
                .shimmerModifier()

        )

    }
}

@Preview
@Composable
fun SearchShimmerItemPrev() {
    MoviesTheme {
        SearchShimmerItem()
    }
}