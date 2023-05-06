package com.example.movies.feature.search.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.imageLoader
import com.examle.movies.core.ui.icon.MoviesIcons
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun Poster(
    image: String?,
    modifier: Modifier = Modifier,
    childModifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(4.dp),
    @DrawableRes errorImage: Int = MoviesIcons.MALE_PERSON,
) {

    val widthHeightModifier: Modifier = if (shape == CircleShape) {
        Modifier.aspectRatio(1f)
    } else {
        when (LocalWindowWidthSizeClass.current) {
            WindowWidthSizeClass.Compact -> Modifier
                .width(180.dp)
                .height(250.dp)
            WindowWidthSizeClass.Medium -> Modifier
                .width(250.dp)
                .height(320.dp)
            WindowWidthSizeClass.Compact -> Modifier
                .width(320.dp)
                .height(390.dp)
            else -> Modifier
                .width(180.dp)
                .height(250.dp)
        }
    }

    val imageLoader = LocalContext.current.imageLoader
    val painter =
        rememberAsyncImagePainter(
            model = image,
            imageLoader = imageLoader,
        )

    val state = painter.state

    Surface(
        modifier = modifier
            .then(widthHeightModifier)
            .then(childModifier),
        shape = shape,
        color = Color.Black
    ) {
        if (state is AsyncImagePainter.State.Error) {
            Image(
                painter = painterResource(id = errorImage),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(32.dp)
                    .clip(shape),
                colorFilter = ColorFilter.tint(
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
                )
            )
            return@Surface
        }

        Image(
            painter = painter,
            alignment = Alignment.Center,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(shape)
        )
    }
}

@Preview()
@Composable
fun PosterPrev() {
    MoviesTheme {
        CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
            Poster(image = null)
        }
    }
}