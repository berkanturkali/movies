package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.imageLoader
import com.examle.movies.core.ui.components.MoviesSurface
import com.examle.movies.core.ui.components.noRippleModifier
import com.examle.movies.core.ui.icon.MoviesIcon
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun TrailerThumbnail(
    thumbnail: String?,
    onThumbnailClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val imageLoader = LocalContext.current.imageLoader

    val widthHeightModifier: Modifier = when (LocalWindowWidthSizeClass.current) {
        WindowWidthSizeClass.Compact -> Modifier
            .width(250.dp)
            .height(150.dp)
        WindowWidthSizeClass.Medium -> Modifier
            .width(320.dp)
            .height(220.dp)
        WindowWidthSizeClass.Compact -> Modifier
            .width(390.dp)
            .height(290.dp)
        else -> Modifier
            .width(250.dp)
            .height(150.dp)
    }

    val painter = rememberAsyncImagePainter(
        model = thumbnail,
        imageLoader = imageLoader,
    )

    MoviesSurface(
        modifier = modifier.then(widthHeightModifier),
        color = Color.LightGray,
        shape = RoundedCornerShape(4.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            contentScale = ContentScale.FillWidth,
            painter = painter,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )

        Icon(
            painter = painterResource(id = MoviesIcon.PLAY),
            contentDescription = null,
            modifier = Modifier.noRippleModifier { onThumbnailClick() }
        )
    }
}

@Preview
@Composable
fun TrailerPrev() {
    MoviesTheme {
        CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
            TrailerThumbnail(thumbnail = "", onThumbnailClick = {})
        }
    }
}