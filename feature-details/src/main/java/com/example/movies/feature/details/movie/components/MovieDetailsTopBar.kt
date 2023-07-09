package com.example.movies.feature.details.movie.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Surface
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.icon.MoviesIcon
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun MovieDetailsTopBar(
    liked: Boolean,
    onFavButtonClick: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .size(30.dp),
                shape = CircleShape,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
                contentColor = MaterialTheme.colorScheme.onSurface
            ) {
                IconButton(onClick = {}, modifier = Modifier.padding(4.dp)) {
                    Icon(
                        painter = painterResource(
                            id = MoviesIcon.BACK
                        ),
                        contentDescription = null,
                    )
                }
            }

            IconToggleButton(
                checked = liked,
                onCheckedChange = onFavButtonClick,
            ) {

                val transition = updateTransition(liked, label = null)

                val color by transition.animateColor(
                    transitionSpec = {
                        if (liked) {
                            spring(stiffness = Spring.StiffnessMedium)
                        } else {
                            tween(durationMillis = 200)
                        }
                    },
                    label = "color"
                ) { isFavorite ->
                    if (isFavorite) Color.Yellow else Color.Black
                }

                val scale by transition.animateFloat(
                    transitionSpec = {
                        keyframes {
                            durationMillis = 500
                            0.0f at 0 with LinearEasing
                            1.2f at 150 with FastOutSlowInEasing
                            1.8f at 300 with FastOutSlowInEasing
                            1.0f at 500
                        }
                    },
                    label = "scale"
                ) {
                    if (it) 1.0f else 0.9f
                }

                Icon(
                    painterResource(id = MoviesIcon.STAR),
                    contentDescription = null,
                    modifier = Modifier
                        .then(if (liked) Modifier.scale(scale) else Modifier)
                        .size(35.dp),
                    tint = color
                )
            }
        }
    }
}

@Preview
@Composable
fun MovieDetailsTopBarPrev() {
    MoviesTheme {
        MovieDetailsTopBar(
            liked = false,
            onFavButtonClick = {}
        )
    }
}