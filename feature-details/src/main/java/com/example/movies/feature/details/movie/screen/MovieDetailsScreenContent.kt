package com.example.movies.feature.details.movie.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.core.model.moviedetails.Movie
import com.example.movies.feature.details.R
import com.example.movies.feature.details.common.components.Overview
import com.example.movies.feature.details.common.components.ScoreView
import com.example.movies.feature.details.movie.components.*

@Suppress("MagicNumber", "UnusedParameter")
fun LazyListScope.movieDetailsScreenContent(
    title: String?,
    date: String?,
    status: String?,
    imageUrl: String?,
    tagline: String?,
    revenue: String?,
    overview: String?,
    score: Float?,
    genres: List<String?>?,
    languages: List<String?>?,
    dominantColor: Color,
    scoreColor: Color?,
    liked: Boolean,
    onFavButtonClick: (Boolean) -> Unit,
) {
    item {
        MoviePoster(
            imageUrl = imageUrl,
            dominantColor = dominantColor,
            liked = liked,
            onFavButtonClick = onFavButtonClick
        )
    }
    item {
        Title(title = title)
    }
    item {
        DetailsSection(
            sectionTitleId = R.string.status_title,
            content = { MovieStatus(status = status) })
    }
    item {
        DetailsSection(
            sectionTitleId = R.string.release_date_title,
            content = { ReleaseDate(date = date) })
    }
    item {
        DetailsSection(sectionTitleId = R.string.revenue_title,
            content = { Revenue(revenue = revenue) }
        )
    }
    item {
        DetailsSection(
            sectionTitleId = R.string.genres_title, content = {
                Genres(genres = genres)
            })
    }
    item {
        DetailsSection(
            sectionTitleId = R.string.user_score_title,
            content = {
                ScoreView(score = score, radius = 36.dp, foregroundIndicatorColor = scoreColor)
            })
    }
    item {
        DetailsSection(sectionTitleId = R.string.tagline_title,
            content = { Tagline(tagline = tagline) }
        )
    }

    item {
        SectionTitle(
            titleId = R.string.languages_title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Languages(languages = languages)
        }
    }
    item {
        SectionTitle(
            titleId = R.string.overview_title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp)
        )
        Overview(overview = overview)
    }

}

@Preview
@Composable
fun MovieDetailsScreenContentPrev() {
    MoviesTheme {
        CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
            LazyColumn {
                movieDetailsScreenContent(
                    title = "Extraction 2", date = "2023-05-31",
                    status = "Released".first()
                        .toString(),
                    imageUrl = "",
                    tagline = "It's how you wear the mask that matters",
                    revenue = "412839759",
                    overview = "After reuniting with Gwen Stacy," +
                            " Brooklyn’s full-time, friendly neighborhood" +
                            " Spider-Man is catapulted across the Multiverse, where" +
                            " he encounters the Spider Society, a team of Spider-People" +
                            " charged with protecting the Multiverse’s very existence." +
                            " But when the heroes clash on how to handle a new threat," +
                            " Miles finds himself pitted against the other Spiders" +
                            " and must set out on his own to save those he loves most.",
                    score = 0.8f,
                    genres = listOf("Action", "Adventure", "Animation", "Science Fiction"),
                    languages = listOf("en", "hi", "it", "es"),
                    dominantColor = Color.Gray,
                    scoreColor = Color.Green,
                    liked = false,
                    onFavButtonClick = {}
                )
            }
        }
    }
}