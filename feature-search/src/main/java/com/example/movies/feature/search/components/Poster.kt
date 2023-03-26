package com.example.movies.feature.search.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
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
    image: String?, modifier: Modifier = Modifier, childModifier: Modifier = Modifier
) {

    val imageLoader = LocalContext.current.imageLoader

    val widthHeightModifier: Modifier = when (LocalWindowWidthSizeClass.current) {
        WindowWidthSizeClass.Compact -> Modifier
            .width(220.dp)
            .height(150.dp)
        WindowWidthSizeClass.Medium -> Modifier
            .width(290.dp)
            .height(220.dp)
        WindowWidthSizeClass.Compact -> Modifier
            .width(360.dp)
            .height(290.dp)
        else -> Modifier
            .width(220.dp)
            .height(150.dp)

    }

    MoviesSurface(
        modifier = modifier
            .then(widthHeightModifier)
            .then(childModifier),
        shape = RoundedCornerShape(4.dp),
        elevation = 8.dp
    ) {
        val painter = rememberAsyncImagePainter(model = image, imageLoader = imageLoader)

        Image(painter = painter, contentDescription = null, contentScale = ContentScale.FillBounds)
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