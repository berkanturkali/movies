package com.example.movies.feature.search.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.examle.movies.core.ui.components.MoviesSurface
import com.examle.movies.core.ui.icon.MoviesIcons
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies_compose.feature.search.R

@Composable
fun RecentSearchesClearButton(
    onClearButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    var expanded by rememberSaveable {
        mutableStateOf(false)
    }

    MoviesSurface(
        modifier = modifier
            .wrapContentWidth()
            .height(20.dp)
            .clickable {
                if (expanded) {
                    onClearButtonClick()
                } else {
                    expanded = true
                }
            },
        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.4f),
        shape = CircleShape,
    ) {

        AnimatedContent(targetState = expanded, transitionSpec = {
            fadeIn(animationSpec = tween(200, 200)) with fadeOut(
                animationSpec = tween(200)
            )
        }) { isExpanded ->
            if (isExpanded) {
                Text(
                    text = stringResource(
                        id = R.string.recent_searches_clear_text_button_text
                    ),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            } else {
                Icon(
                    painter = painterResource(MoviesIcons.CLEAR),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Preview
@Composable
fun RecentSearchesClearButtonPrev() {
    MoviesTheme {
        RecentSearchesClearButton(onClearButtonClick = { /*TODO*/ })
    }
}