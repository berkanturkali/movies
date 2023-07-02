package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.icon.MoviesIcon
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.feature.details.R

@Composable
fun SeeAllButton(
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = modifier.clickable(
            interactionSource = interactionSource,
            indication = null
        ) {
            onItemClick()
        }, verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.see_all_button_text),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.offset(y = 1.dp)
        )

        Icon(
            painter = painterResource(id = MoviesIcon.NEXT),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface,
        )
    }

}

@Preview
@Composable
fun SeeAllButtonPrev() {
    MoviesTheme {
        SeeAllButton(onItemClick = {})
    }
}