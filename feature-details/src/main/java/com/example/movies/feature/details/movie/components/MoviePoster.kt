package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.imageLoader
import com.examle.movies.core.ui.components.MoviesSurface
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun MoviePoster(
    imageUrl: String?,
    dominantColor: Color,
    modifier: Modifier = Modifier
) {

    val imageLoader = LocalContext.current.imageLoader


    val painter = rememberAsyncImagePainter(
        model = imageUrl,
        imageLoader = imageLoader,
    )

    OutlinedCard(
        modifier = modifier.padding(horizontal = 8.dp),
        border = BorderStroke(
            0.5.dp,
            color = MaterialTheme.colorScheme.onSurface
        ),
        elevation = CardDefaults.outlinedCardElevation(
            defaultElevation = 8.dp
        ),
    ) {

        MoviesSurface(
            modifier = modifier.aspectRatio(1f, true),
            color = dominantColor,
            shape = RoundedCornerShape(4.dp),
        ) {
            Image(
                alignment = Alignment.Center,
                contentScale = ContentScale.Inside,
                painter = painter,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview
@Composable
fun MoviePosterPrev() {
    MoviesTheme {
        MoviePoster(imageUrl = "", dominantColor = Color.Gray)
    }
}