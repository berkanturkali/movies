package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.core.model.moviedetails.Keyword
import com.example.movies.feature.details.R

@Composable
fun Keywords(
    keywords: List<Keyword>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        SectionTitle(
            titleId = R.string.keywords_title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
        )
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(
                8.dp, Alignment.CenterHorizontally
            ),
        ) {
            keywords.forEach { keyword ->
                keyword.name?.let { name ->
                    KeywordItem(keyword = name)
                }
            }
        }
    }
}

@Preview
@Composable
fun KeywordsPrev() {
    MoviesTheme {
        Keywords(
            keywords = listOf(
                Keyword("Lorem"),
                Keyword("Lorem"),
                Keyword("Lorem"),
                Keyword("Lorem"),
                Keyword("Lorem"),
                Keyword("Lorem"),
                Keyword("Lorem"),
                Keyword("Lorem"),
                Keyword("Lorem"),
                Keyword("Lorem"),
            ),
        )
    }
}