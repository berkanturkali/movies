package com.example.movies.feature.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.components.shimmerModifier
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun SearchShimmerItem(modifier: Modifier = Modifier) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation = 4.dp, clip = false)
            .background(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f)
            )
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Poster(
            image = "",
            childModifier = Modifier.shimmerModifier(),
            modifier = Modifier.weight(2f),
        )

        Spacer(
            modifier = Modifier
                .weight(2f)
                .height(20.dp)
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