package com.example.movies.feature.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import coil.imageLoader
import com.examle.movies.core.ui.icon.MoviesIcons
import com.example.movies_compose.feature.home.R

@Composable
fun HighlightedMovieExpanded(
    modifier: Modifier = Modifier
) {

    val imageLoader = LocalContext.current.imageLoader

    val painter = rememberAsyncImagePainter(model = "", imageLoader = imageLoader)


    Box(modifier = modifier) {
        Image(
            painter = painter,
            contentDescription = null,
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.7f)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.surface,
                            Color.Transparent,
                        ),
                    ),
                ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    dimensionResource(id = com.examle.movies.core.ui.R.dimen.dimen_16),
                    Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(horizontal = dimensionResource(id = com.examle.movies.core.ui.R.dimen.dimen_8))
            ) {
                MovieTitle(title = "STRANGER THINGS")
                MovieDescription(
                    description = "Lorem Ipsum is simply dummy text of the printing" +
                            " and typesetting industry. Lorem Ipsum has been the industry's" +
                            " standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled"
                )
                ButtonPanel()
            }
        }
    }
}


@Composable
private fun MovieTitle(
    modifier: Modifier = Modifier,
    title: String,
) {
    Text(
        modifier = modifier,
        text = title,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.ExtraBold,
        maxLines = 3,
        color = Color.White
    )
}

@Composable
private fun MovieDescription(
    modifier: Modifier = Modifier,
    description: String,
) {
    Text(
        modifier = modifier,
        text = description,
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Normal,
        maxLines = 4,
        color = Color.White
    )
}

@Composable
private fun ButtonPanel(
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(
            dimensionResource(id = com.examle.movies.core.ui.R.dimen.dimen_20),
            Alignment.CenterHorizontally
        )
    ) {
        PlayButton()
        MyListButton()

    }
}


@Composable
private fun MyListButton(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            painter = painterResource(id = MoviesIcons.ADD),
            tint = MaterialTheme.colorScheme.onPrimary,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = com.examle.movies.core.ui.R.dimen.dimen_4)))
        Text(
            text = stringResource(id = R.string.my_list_button_text),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun PlayButton(
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(id = com.examle.movies.core.ui.R.dimen.dimen_8)),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        onClick = {}) {
        Icon(
            painter = painterResource(id = MoviesIcons.PLAY),
            contentDescription = null,
            tint = Color.Black
        )
        Text(
            text = stringResource(id = R.string.play_button_text),
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}