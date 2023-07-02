package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
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
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun MovieDetailsStickyTopBar(
    dominantColor: Color,
    image: String?,
    title: String?,
    onTopBarClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val imageLoader = LocalContext.current.imageLoader

    val interactionSource = remember { MutableInteractionSource() }

    val widthHeightModifier: Modifier = when (LocalWindowWidthSizeClass.current) {
        WindowWidthSizeClass.Compact -> Modifier
            .width(60.dp)
            .height(95.dp)
        WindowWidthSizeClass.Medium -> Modifier
            .width(95.dp)
            .height(130.dp)
        WindowWidthSizeClass.Compact -> Modifier
            .width(130.dp)
            .height(95.dp)
        else -> Modifier
            .width(60.dp)
            .height(95.dp)
    }

    OutlinedCard(
        modifier = modifier.clickable(interactionSource = interactionSource, indication = null) {
            onTopBarClick()
        },
        border = BorderStroke(
            0.5.dp, color = MaterialTheme.colorScheme.onSurface
        ),
        elevation = CardDefaults.outlinedCardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.outlinedCardColors(
            containerColor = dominantColor
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            MoviesSurface(
                color = Color.LightGray, modifier = Modifier.then(widthHeightModifier)
            ) {
                val painter = rememberAsyncImagePainter(
                    model = image,
                    imageLoader = imageLoader,
                )

                Image(
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillBounds,
                    painter = painter,
                    modifier = Modifier.fillMaxWidth(),
                    contentDescription = null,
                )
            }

            title?.let {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }
        }
    }
}

@Preview
@Composable
fun MovieDetailsStickyTopBarPrev() {
    MoviesTheme {
        CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
            MovieDetailsStickyTopBar(
                image = "", title = "Title",
                dominantColor = MaterialTheme.colorScheme.onSurface,
                onTopBarClick = {}
            )
        }
    }
}