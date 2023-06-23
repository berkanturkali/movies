package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.icon.MoviesIcons
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
        )

        Icon(
            painter = painterResource(id = MoviesIcons.NEXT), contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface
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