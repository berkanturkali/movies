package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.core.model.moviedetails.Cast
import com.example.movies.feature.details.R

@Composable
fun Cast(
    cast: List<Cast>,
    modifier: Modifier = Modifier,
) {
    if (cast.isNotEmpty()) {
        val topTen = cast.take(10)
        DetailsListSection(
            modifier = modifier,
            sectionTitleId = R.string.cast_title,
            content = {
                LazyRow(
                    modifier = Modifier,
                    contentPadding = PaddingValues(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items(topTen) {
                        CastItem(
                            image = it.image,
                            name = it.name,
                        )
                    }
                }
            },
            showSeeAllContent = cast.size > topTen.size,
            count = cast.size
        )
    }
}

@Preview
@Composable
fun CastPrev() {
    MoviesTheme {
        Cast()
    }
}