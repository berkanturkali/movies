package com.example.movies.feature.search.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.imageLoader
import com.examle.movies.core.ui.components.MoviesSurface
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun Poster(
    image: String?,
    modifier: Modifier = Modifier,
    childModifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(4.dp),
) {

    val imageLoader = LocalContext.current.imageLoader

    MoviesSurface(
        modifier = modifier
            .aspectRatio(1f)
            .then(childModifier),
        shape = shape,
        elevation = 4.dp,
    ) {
        val painter = rememberAsyncImagePainter(model = image, imageLoader = imageLoader)

        Image(
            painter = painter,
            alignment = Alignment.Center,
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
    }
}

@Preview()
@Composable
fun PosterPrev() {
    MoviesTheme {
        Poster(image = null)
    }
}