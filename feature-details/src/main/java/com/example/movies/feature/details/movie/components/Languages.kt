package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
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
            .width(32.dp)
            .height(30.dp)
        WindowWidthSizeClass.Medium -> Modifier
            .width(52.dp)
            .height(50.dp)
        WindowWidthSizeClass.Compact -> Modifier
            .width(72.dp)
            .height(70.dp)
        else -> Modifier
            .width(32.dp)
            .height(30.dp)
    }

    languages?.let { languages ->
        LazyRow(horizontalArrangement = Arrangement.spacedBy(4.dp), userScrollEnabled = false) {
            items(languages) { language ->
                language?.let {
                    Column(
                        modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MoviesSurface(
                            modifier = Modifier.then(widthHeightModifier), color = Color.Transparent
                        ) {
                            val newLanguage = if (language.equals("en", true)) {
                                "us"
                            } else if (language.equals("hi", true)) {
                                "in"
                            } else {
                                language
                            }
                            val painter = rememberAsyncImagePainter(
                                model = "https://flagsapi.com/${newLanguage.uppercase()}/flat/64.png",
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
    }
}