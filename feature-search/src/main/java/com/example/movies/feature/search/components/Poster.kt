package com.example.movies.feature.search.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.imageLoader
import com.examle.movies.core.ui.components.MoviesSurface
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun Poster(
    image: String?,
    modifier: Modifier = Modifier,
    childModifier: Modifier = Modifier
) {

    val imageLoader = LocalContext.current.imageLoader

    MoviesSurface(
        modifier = modifier
            .aspectRatio(1f)
            .then(childModifier),
        shape = RoundedCornerShape(4.dp),
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
    CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
        MoviesTheme {
            Poster(image = null)
        }
    }
}