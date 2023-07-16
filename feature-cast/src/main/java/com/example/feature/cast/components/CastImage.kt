package com.example.feature.cast.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.imageLoader
import com.examle.movies.core.ui.icon.MoviesIcon
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun CastImage(
    image: String?,
    modifier: Modifier = Modifier,
    @DrawableRes errorImage: Int = MoviesIcon.MALE_PERSON,
) {

    val imageLoader = LocalContext.current.imageLoader
    val painter = rememberAsyncImagePainter(
        model = image,
        imageLoader = imageLoader,
    )

    val state = painter.state

    Box(
        modifier = modifier
            .aspectRatio(1f)
            .background(color = Color.Black, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        if (state is AsyncImagePainter.State.Error) {
            Image(
                painter = painterResource(id = errorImage),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .clip(CircleShape),
                colorFilter = ColorFilter.tint(
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
                ),
                alignment = Alignment.Center
            )
        }

        Image(
            painter = painter,
            alignment = Alignment.Center,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .clip(CircleShape)
                .fillMaxSize()
        )
    }
}

@Preview
@Composable
fun CastImagePrev() {
    MoviesTheme {
        CastImage(image = "")
    }
}

