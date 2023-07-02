package com.example.movies.feature.details.movie.components

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.icon.MoviesIcon
import com.examle.movies.core.ui.theme.MoviesTheme

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun MovieDetailsTopBar(
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
                IconButton(onClick = {},modifier = Modifier.padding(4.dp)) {
                    Icon(
                        painter = painterResource(
                            id = MoviesIcon.BACK
                        ),
                        contentDescription = null,
                    )
                }
            }

            IconToggleButton(
                checked = true,
                onCheckedChange = {

                }
            ) {

                val transition = updateTransition(true, label = null)

                val tint by transition.animateColor(label = "Tint") {
                    if (it) Color.Yellow else MaterialTheme.colorScheme.onSurface
                }

                val size by transition.animateDp(
                    transitionSpec = {
                        if (false isTransitioningTo true) {
                            keyframes {
                                durationMillis = 250
                                30.dp at 0 with LinearOutSlowInEasing
                                35.dp at 15 with FastOutLinearInEasing
                                40.dp at 75
                                35.dp at 150
                            }
                        } else {
                            spring(stiffness = Spring.StiffnessVeryLow)
                        }
                    },
                    label = "Size"
                ) {
                    30.dp
                }

//                Icon(
//                    painter = if (true) painterResource(
//                        id = com.example.jetgames.common.R.drawable.ic_filled_star
//                    ) else painterResource(
//                        id = com.example.jetgames.common.R.drawable.ic_star
//                    ),
//                    contentDescription = null,
//                    tint = tint,
//                    modifier = Modifier.size(size)
//                )
            }
        }
    }
}

@Preview
@Composable
fun MovieDetailsTopBarPrev() {
    MoviesTheme {
        MovieDetailsTopBar()
    }
}