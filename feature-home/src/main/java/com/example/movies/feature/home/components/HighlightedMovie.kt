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
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import coil.imageLoader
import com.examle.movies.core.ui.components.MoviesSurface
import com.examle.movies.core.ui.icon.MoviesIcons
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies_compose.feature.home.R

@Composable
fun HighlightedMovie(
    modifier: Modifier = Modifier,
) {

    val imageLoader = LocalContext.current.imageLoader

    val painter = rememberAsyncImagePainter(model = "", imageLoader = imageLoader)

        MoviesSurface(color = Color.Transparent,modifier = modifier){
            Box {
            Image(
                painter = painter,
                contentDescription = null,
            )

            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.surface,
                                Color.Transparent,
                            ),
                        ),
                    ),

                ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(
                            bottom = dimensionResource(
                                id = com.examle.movies.core.ui.R.dimen.dimen_32
                            )
                        ),
                ) {
                    MyListButton(modifier = Modifier.weight(1f))
                    PlayButton(modifier = Modifier.weight(1.5f))
                    InfoButton(modifier = Modifier.weight(1f))
                }
            }
        }
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                dimensionResource(id = com.examle.movies.core.ui.R.dimen.dimen_4),
                Alignment.CenterHorizontally
            ),
        ) {
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
}

@Composable
private fun InfoButton(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = MoviesIcons.INFO,
            tint = MaterialTheme.colorScheme.onPrimary,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = com.examle.movies.core.ui.R.dimen.dimen_4)))
        Text(
            text = stringResource(id = R.string.info_button_text),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
private fun HighlightedMoviePrev() {
    MoviesTheme {
        HighlightedMovie()
    }
}