package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.theme.MoviesTheme

@Composable
fun KeywordItem(
    keyword: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.padding(top = 8.dp).border(
            BorderStroke(
                0.5.dp,
                color = MaterialTheme.colorScheme.onSurface,

                ),
            shape = RoundedCornerShape(4.dp)
        ),
    ) {
        Text(
            text = keyword,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        )
    }
}

@Preview
@Composable
fun KeywordItemPrev() {
    MoviesTheme {
        KeywordItem(keyword = "Keyword")
    }
}