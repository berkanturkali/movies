package com.examle.movies.core.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.icon.MoviesIcon
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun MoviesFab(
    @DrawableRes icon: Int,
    onFabClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f),
    shape: Shape = CircleShape,
) {
    FloatingActionButton(
        onClick = onFabClick,
        modifier = modifier,
        containerColor = containerColor,
        shape = shape,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 0.dp
        )
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = null)
    }
}

@Preview
@Composable
fun MoviesFabPrev() {
    MoviesTheme {
        MoviesFab(icon = MoviesIcon.ARROW_INWARD, onFabClick = { /*TODO*/ })
    }
}