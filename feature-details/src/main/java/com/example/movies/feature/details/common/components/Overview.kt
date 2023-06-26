package com.example.movies.feature.details.common.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun Overview(
    overview: String?,
    modifier: Modifier = Modifier
) {
    overview?.let {
        Text(
            modifier = modifier.padding(8.dp),
            text = overview,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
fun OverviewPrev() {
    MoviesTheme {
        Overview(
            overview = "After reuniting with Gwen Stacy," +
                    " Brooklyn’s full-time, friendly neighborhood" +
                    " Spider-Man is catapulted across the Multiverse," +
                    " where he encounters the Spider Society, a team of " +
                    "Spider-People charged with protecting the Multiverse’s very " +
                    "existence. But when the heroes clash on how to handle a new threat," +
                    " Miles finds himself pitted against the other Spiders and must" +
                    " set out on his own to save those he loves most."
        )
    }
}