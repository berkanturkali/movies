package com.example.movies.feature.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.components.MoviesSurface
import com.examle.movies.core.ui.icon.MoviesIcons
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies_compose.feature.home.R

@Composable
fun HomeScreenAppBar(
    modifier: Modifier = Modifier,
) {
    MoviesSurface(
        modifier = modifier
            .padding(vertical = 12.dp, horizontal = 8.dp),
    ) {
        MenuBar()
    }
}


@Composable
private fun MenuBar() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Logo(modifier = Modifier.weight(0.1f))
        Menu(modifier = Modifier.weight(0.9f))
    }
}

@Composable
private fun Logo(
    modifier: Modifier = Modifier
) {
    val size = when (LocalWindowWidthSizeClass.current) {
        WindowWidthSizeClass.Compact -> 30.dp
        WindowWidthSizeClass.Medium -> 90.dp
        WindowWidthSizeClass.Expanded -> 150.dp
        else -> 30.dp
    }
    Image(
        painter = painterResource(id = MoviesIcons.LOGO),
        contentDescription = null,
        modifier = modifier.size(size)
    )
}

@Composable
private fun Menu(
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        MenuItem(modifier = Modifier.weight(1f), text = stringResource(id = R.string.tv_shows))
        MenuItem(modifier = Modifier.weight(1f), text = stringResource(id = R.string.movies))
        MenuItem(modifier = Modifier.weight(1f), text = stringResource(id = R.string.categories))
    }
}

@Composable
private fun MenuItem(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(
        text = text,
        color = MaterialTheme.colorScheme.onPrimary,
        style = MaterialTheme.typography.bodyMedium,
        maxLines = 1,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Preview(device = Devices.PHONE)
@Composable
fun HomeScreenAppBarSmallPrev() {
    CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
        MoviesTheme {
            HomeScreenAppBar()
        }
    }
}

@Preview(device = Devices.AUTOMOTIVE_1024p)
@Composable
fun HomeScreenAppBarMediumPrev() {
    CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Medium) {
        MoviesTheme {
            HomeScreenAppBar()
        }
    }
}

@Preview(device = Devices.NEXUS_10)
@Composable
fun HomeScreenAppBarExpandedPrev() {
    CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Expanded) {
        MoviesTheme {
            HomeScreenAppBar()
        }
    }
}