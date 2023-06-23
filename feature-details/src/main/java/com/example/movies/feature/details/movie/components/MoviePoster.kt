package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
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
    modifier: Modifier = Modifier
) {

    val imageLoader = LocalContext.current.imageLoader

    val painter = rememberAsyncImagePainter(
        model = imageUrl,
        imageLoader = imageLoader,
    )

    MoviesSurface(
        modifier = modifier.aspectRatio(1f, true),
        color = Color.LightGray,
        shape = RoundedCornerShape(4.dp)
    ) {
        Image(
            alignment = Alignment.Center,
            contentScale = ContentScale.FillBounds,
            painter = painter,
            contentDescription = null,
        )
    }
}

@Preview
@Composable
fun MoviePosterPrev() {
    MoviesTheme {
        MoviePoster(imageUrl = "")
    }
}