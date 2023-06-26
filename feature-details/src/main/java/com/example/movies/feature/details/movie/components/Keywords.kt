package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.feature.details.R

@Composable
fun Keywords(
    keywords: List<String?>?,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        keywords?.let {
            SectionTitle(
                titleId = R.string.keywords_title,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
            )
            FlowRow(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(
                    8.dp, Alignment.CenterHorizontally
                ),
            ) {
                keywords.forEach { keyword ->
                    keyword?.let {
                        KeywordItem(keyword = keyword)
                    }
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
                "sacrifice", "villain", "comic book", "sequel", "superhero",
                "based on comic",
                "alternate dimension", "alternate version", "super power",
                "brooklyn, new york city",
                "superhero team", "spider bite", "super villain", "cliffhanger",
                "teen superhero", "alternate universe", "female superhero",
                "cartoon spider"
            ),
        )
    }
}