package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.icon.MoviesIcons
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun ReviewItemRating(
    rating: String?,
    modifier: Modifier = Modifier
) {
    rating?.let {
        Box(
            modifier = modifier.background(Color.Black, shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 4.dp)
                    .height(IntrinsicSize.Max),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(id = MoviesIcons.STAR), contentDescription = null,
                    tint = Color.White
                )

                Text(
                    modifier = Modifier.offset(y = 2.dp),
                    text = rating,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }
        }
    }
}

@Preview
@Composable
fun ReviewItemRatingPrev() {
    MoviesTheme {
        ReviewItemRating(rating = "5")
    }
}