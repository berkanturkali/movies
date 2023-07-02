package com.example.movies.feature.details.movie.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.imageLoader
import com.examle.movies.core.ui.icon.MoviesIcon
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun CastItem(
    image: String?,
    name: String?,
    character: String?,
    modifier: Modifier = Modifier,
    @DrawableRes errorImage: Int = MoviesIcon.MALE_PERSON,
) {

    val imageLoader = LocalContext.current.imageLoader
    val painter = rememberAsyncImagePainter(
        model = image,
        imageLoader = imageLoader,
    )

    val state = painter.state

    Column(
        modifier = modifier
            .width(IntrinsicSize.Max)
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
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
        name?.let {
            Text(
                text = name,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
        }
        character?.let {
            Text(
                text = character,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
            )

        }
    }
}

@Preview
@Composable
fun CastItemPrev() {
    MoviesTheme {
        CastItem(image = "", name = "Shameik Moore", "Miles Morales / Spider-Man (voice)")
    }
}