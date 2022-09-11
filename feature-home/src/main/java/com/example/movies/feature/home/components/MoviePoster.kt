package com.example.movies.feature.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
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
import com.examle.movies.core.ui.providers.LocalWindowSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun MoviePoster(
    modifier: Modifier = Modifier,
    image: String?,
) {

    val imageLoader = LocalContext.current.imageLoader

    val windowSizeClass = LocalWindowSizeClass.current

    val widthHeightModifier: Modifier = when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Companion.Compact -> Modifier
            .width(150.dp)
            .height(220.dp)
        WindowWidthSizeClass.Medium -> Modifier
            .width(220.dp)
            .height(290.dp)
        WindowWidthSizeClass.Compact -> Modifier
            .width(300.dp)
            .height(370.dp)
        else -> Modifier
            .width(150.dp)
            .height(220.dp)
    }

    MoviesSurface(
        modifier = modifier.then(widthHeightModifier),
        color = Color.LightGray,
    ) {
        val painter = rememberAsyncImagePainter(
            model = image,
            imageLoader = imageLoader,
        )

        Image(
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth,
            painter = painter,
            contentDescription = null,
        )
    }
}


@Preview
@Composable
fun MoviePosterPrev() {
    MoviesTheme {
        MoviePoster(image = null)
    }
}

