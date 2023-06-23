package com.example.movies.feature.details.movie.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.feature.details.R
import com.example.movies.feature.details.common.components.ScoreView
import com.example.movies.feature.details.movie.components.*

@Composable
fun MovieDetailsScreenContent(
    title: String?,
    date: String?,
    status: String?,
    imageUrl: String?,
    tagline: String?,
    revenue: String,
    overview: String?,
    reviewerName: String?,
    reviewerImage: String?,
    reviewerRating: String?,
    review: String?,
    score: Float,
    genres: List<String>?,
    languages: List<String>?,
    keywords: List<String>?,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        modifier = modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            MoviePoster(imageUrl = imageUrl)
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
                    ScoreView(score = score, radius = 36.dp)
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
//        item {
//            SectionTitle(
//                titleId = R.string.overview_title,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 12.dp)
//            )
//            Overview(overview = overview)
//        }

        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
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

        item {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                SectionTitle(
                    titleId = R.string.reviews_title,
                )
                SeeAllButton(onItemClick = {})
            }
            HorizontalPager(
                pageCount = 3,
            ) {
                ReviewItem(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    image = reviewerImage,
                    userName = reviewerName,
                    date = date,
                    review = review,
                    rating = reviewerRating
                )
            }
        }

        item {
            keywords?.let {
                SectionTitle(
                    titleId = R.string.keywords_title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                )
                FlowRow(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(
                        8.dp, Alignment.CenterHorizontally
                    ),
                ) {
                    keywords.forEach { keyword ->
                        KeywordItem(keyword = keyword)
                    }
                }
            }
        }

    }
}

@Preview
@Composable
fun MovieDetailsScreenContentPrev() {
    MoviesTheme {
        CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
            MovieDetailsScreenContent(
                title = "Spider-Man: Across the Spider-Verse", date = "2023-05-31",
                status = "Released".first()
                    .toString(),
                imageUrl = "",
                tagline = "It's how you wear the mask that matters",
                revenue = "412839759",
                overview = "After reuniting with Gwen Stacy, Brooklyn’s full-time, friendly neighborhood Spider-Man is catapulted across the Multiverse, where he encounters the Spider Society, a team of Spider-People charged with protecting the Multiverse’s very existence. But when the heroes clash on how to handle a new threat, Miles finds himself pitted against the other Spiders and must set out on his own to save those he loves most.",
                score = 0.8f,
                genres = listOf("Action", "Adventure", "Animation", "Science Fiction"),
                languages = listOf("en", "hi", "it", "es"),
                keywords = listOf(
                    "sacrifice", "villain", "comic book", "sequel", "superhero", "based on comic",
                    "alternate dimension", "alternate version", "super power",
                    "brooklyn, new york city",
                    "superhero team", "spider bite", "super villain", "cliffhanger",
                    "teen superhero", "alternate universe", "female superhero",
                    "cartoon spider"
                ),
                reviewerImage = "",
                reviewerName = "MovieGuys",
                review = "Secret Invasion is rather what I have come to expect from US entertainment these days, that is, not a lot.",
                reviewerRating = "5"
            )
        }
    }
}