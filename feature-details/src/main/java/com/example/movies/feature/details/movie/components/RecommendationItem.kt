package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.imageLoader
import com.examle.movies.core.ui.components.MoviesSurface
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.feature.details.common.components.ScoreView

@Composable
fun RecommendationItem(
    image: String?,
    score: Float?,
    name: String?,
    modifier: Modifier = Modifier
) {
    val imageLoader = LocalContext.current.imageLoader

    val widthHeightModifier: Modifier = when (LocalWindowWidthSizeClass.current) {
        WindowWidthSizeClass.Compact -> Modifier
            .width(150.dp)
            .height(220.dp)
        WindowWidthSizeClass.Medium -> Modifier
            .width(220.dp)
            .height(290.dp)
        WindowWidthSizeClass.Compact -> Modifier
            .width(290.dp)
            .height(360.dp)
        else -> Modifier
            .width(150.dp)
            .height(220.dp)
    }

    Column(modifier = modifier.width(IntrinsicSize.Min)) {

        Box(modifier = Modifier.then(widthHeightModifier), contentAlignment = Alignment.TopEnd) {

            MoviesSurface(
                color = Color.LightGray,
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

            ScoreView(score = score, radius = 20.dp, modifier = Modifier.padding(4.dp))
        }
        name?.let {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }

}

@Preview
@Composable
fun RecommendationItemPrev() {
    MoviesTheme {
        CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
            RecommendationItem(image = "", score = 0.6f, name = "Red Island")
        }
    }
}