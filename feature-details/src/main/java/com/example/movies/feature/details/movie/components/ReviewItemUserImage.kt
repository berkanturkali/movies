package com.example.movies.feature.search.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.imageLoader
import com.examle.movies.core.ui.icon.MoviesIcons
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun ReviewItemUserImage(
    image: String?,
    firstLetter: String?,
    modifier: Modifier = Modifier,
    @DrawableRes errorImage: Int = MoviesIcons.MALE_PERSON,
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
            .background(Color.Black, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        if (state is AsyncImagePainter.State.Error) {
            if (!firstLetter.isNullOrBlank()) {
                Text(
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f),
                    text = firstLetter,
                    style = MaterialTheme.typography.displayMedium.copy(fontSize = 250.sp),
                    textAlign = TextAlign.Center,
                )
            } else {
                Image(
                    painter = painterResource(id = errorImage),
                    contentDescription = null,
                    contentScale = ContentScale.Fit, modifier = Modifier
                        .size(250.dp)
                        .padding(32.dp)
                        .clip(CircleShape), colorFilter = ColorFilter.tint(
                        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f)
                    )
                )
            }
            return@Box
        }

        Image(
            painter = painter,
            alignment = Alignment.Center,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape)
        )
    }
}

@Preview
@Composable
fun ReviewItemUserImagePrev() {
    MoviesTheme {
        ReviewItemUserImage(image = "", firstLetter = "B")
    }
}