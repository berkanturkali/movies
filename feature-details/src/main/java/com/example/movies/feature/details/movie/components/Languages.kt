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
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.imageLoader
import com.examle.movies.core.ui.components.MoviesSurface
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass


@Composable
fun Languages(
    languages: List<String?>?,
    modifier: Modifier = Modifier
) {

    val imageLoader = LocalContext.current.imageLoader

    val widthHeightModifier: Modifier = when (LocalWindowWidthSizeClass.current) {
        WindowWidthSizeClass.Compact -> Modifier
            .width(40.dp)
            .height(30.dp)
        WindowWidthSizeClass.Medium -> Modifier
            .width(60.dp)
            .height(50.dp)
        WindowWidthSizeClass.Compact -> Modifier
            .width(80.dp)
            .height(70.dp)
        else -> Modifier
            .width(40.dp)
            .height(30.dp)
    }

    languages?.forEach { language ->
        if(!language.isNullOrEmpty()) {
            Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                MoviesSurface(
                    modifier = Modifier.then(widthHeightModifier), color = Color.Transparent
                ) {
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
                    text = language.uppercase(),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}