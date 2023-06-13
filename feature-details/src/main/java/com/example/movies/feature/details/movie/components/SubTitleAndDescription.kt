package com.example.movies.feature.details.movie.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.feature.details.R

@Composable
fun SubTitleAndDescription(
    @StringRes titleId: Int,
    description: String,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = titleId),
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            text = description,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview
@Composable
fun SubTitleAndDescriptionPrev() {
    MoviesTheme {
        SubTitleAndDescription(titleId = R.string.status_title, description = "Release")
    }
}