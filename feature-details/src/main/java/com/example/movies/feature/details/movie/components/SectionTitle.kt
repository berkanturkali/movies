package com.example.movies.feature.details.movie.components

import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.feature.details.R

@Composable
fun SectionTitle(
    @StringRes titleId: Int,
    modifier: Modifier = Modifier
) {

    Text(
        text = stringResource(id = titleId),
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = modifier
    )
}

@Preview
@Composable
fun SectionTitlePrev() {
    MoviesTheme {
        SectionTitle(titleId = R.string.status_title)
    }
}