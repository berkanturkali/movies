package com.example.movies.feature.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun SearchGridItem(
    image: String?,
    name: String,
    onItemClick: () -> Unit,
    showPosterView: Boolean = true,
    shape: RoundedCornerShape = RoundedCornerShape(4.dp),
) {
    if (showPosterView) {
        SearchGridItemPosterView(
            image = image,
            name = name,
            shape = shape,
            onItemClick = onItemClick
        )
    } else {
        SearchGridItemTextView(
            name = name,
            shape = shape,
            onItemClick = onItemClick
        )
    }
}


@Composable
private fun SearchGridItemPosterView(
    image: String?,
    name: String,
    shape: RoundedCornerShape,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clickable {
                onItemClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        //image
        Poster(image = image, shape = shape)

        //name
        Name(name = name, textAlign = TextAlign.Center)
    }
}

@Composable
private fun SearchGridItemTextView(
    name: String,
    shape: RoundedCornerShape,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val widthHeightModifier: Modifier =
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

    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .then(widthHeightModifier)
                .background(color = Color.Black, shape = shape)
                .clickable {
                    onItemClick()
                },
            contentAlignment = Alignment.Center
        ) {
            Name(name = name, textAlign = TextAlign.Center, modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview
@Composable
fun SearchGridItemTextViewPrev() {
    MoviesTheme {
        CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
            SearchGridItemTextView(
                name = "Jurassic Lorem Ipsum",
                shape = RoundedCornerShape(4.dp),
                onItemClick = {})
        }
    }
}


@Preview
@Composable
fun SearchGridItemPrev() {
    MoviesTheme {
        CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
            SearchGridItem(name = "fsadfsafasdf", image = "", onItemClick = {})
        }
    }
}