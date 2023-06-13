package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.imageLoader
import com.examle.movies.core.ui.components.MoviesSurface
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass

@Composable
fun Languages(
    languages: List<String>,
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

    languages.forEach { language ->
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            MoviesSurface(modifier = Modifier.then(widthHeightModifier)) {
                val painter = rememberAsyncImagePainter(
                    model = "https://flagsapi.com/${language.uppercase()}/flat/64.png",
                    imageLoader = imageLoader
                )
                Image(
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillBounds,
                    painter = painter,
                    modifier = Modifier.fillMaxWidth(),
                    contentDescription = null,
                )
            }

            Text(
                text = language, style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}