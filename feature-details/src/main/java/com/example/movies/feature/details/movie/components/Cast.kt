package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.feature.details.R

@Composable
fun Cast(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        ) {
            SectionTitle(
                titleId = R.string.cast_title,
            )
            SeeAllButton(onItemClick = {})
        }

        LazyRow(
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            item {
                repeat(10) {
                    CastItem(
                        image = "",
                        name = "Name $it",
                        character = "Character $it"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CastPrev() {
    MoviesTheme {
        Cast()
    }
}