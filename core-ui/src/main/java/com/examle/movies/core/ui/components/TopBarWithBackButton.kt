package com.examle.movies.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.examle.movies.core.ui.icon.MoviesIcon
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun TopBarWithBackButton(
    onBackButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    title: String? = null,
    background: Color = Color.Transparent
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(color = background)
    ) {
        val (backButton, titleText, divider) = createRefs()
        Surface(
            modifier = Modifier
                .size(30.dp)
                .constrainAs(backButton) {
                    top.linkTo(parent.top, margin = 16.dp)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                },
            shape = CircleShape,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
            contentColor = MaterialTheme.colorScheme.onSurface
        ) {
            IconButton(onClick = {
                onBackButtonClick()
            }) {
                Icon(
                    painter = painterResource(
                        id = MoviesIcon.BACK
                    ),
                    contentDescription = null,
                )
            }
        }

        title?.let {
            Text(
                text = title,
                modifier = Modifier
                    .constrainAs(titleText) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }

        MoviesDivider(
            modifier = Modifier.constrainAs(divider) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

    }
}

@Preview
@Composable
fun TopBarWithBackButtonPrev() {
    MoviesTheme {
        TopBarWithBackButton(onBackButtonClick = { }, title = "Title")
    }
}