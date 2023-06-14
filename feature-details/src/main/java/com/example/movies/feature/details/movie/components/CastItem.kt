package com.example.movies.feature.details.movie.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import com.examle.movies.core.ui.icon.MoviesIcons
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun CastItem(
    image: String?,
    name: String?,
    character: String?,
    modifier: Modifier = Modifier,
    @DrawableRes errorImage: Int = MoviesIcons.MALE_PERSON,
) {

    val imageLoader = LocalContext.current.imageLoader
    val painter = rememberAsyncImagePainter(
        model = image,
        imageLoader = imageLoader,
    )

    val state = painter.state

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Surface(
            modifier = Modifier.aspectRatio(1f), shape = CircleShape, color = Color.Black
        ) {
            if (state is AsyncImagePainter.State.Error) {
                Image(
                    painter = painterResource(id = errorImage), contentDescription = null,
                    contentScale = ContentScale.Fit, modifier = Modifier
                        .padding(32.dp)
                        .clip(CircleShape), colorFilter = ColorFilter.tint(
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
                modifier = Modifier.clip(CircleShape)
            )
        }
        name?.let {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = name,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
        }
        character?.let {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = character,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
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