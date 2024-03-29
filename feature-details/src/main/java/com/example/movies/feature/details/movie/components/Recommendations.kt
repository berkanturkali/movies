package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.examle.movies.core.ui.providers.LocalWindowWidthSizeClass
import com.examle.movies.core.ui.theme.MoviesTheme
import com.example.movies.core.model.moviedetails.Recommendation
import com.example.movies.feature.details.R

@Composable
fun Recommendations(
    recommendations: List<Recommendation>,
    scoreColor: Color?,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    DetailsListSection(
        modifier = modifier,
        sectionTitleId = R.string.recommendations_title,
        content = {
            LazyRow(
                contentPadding = PaddingValues(8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                items(recommendations) { recommendation ->
                    RecommendationItem(
                        image = recommendation.image,
                        score = recommendation.score,
                        scoreColor = scoreColor,
                        onItemClick = {
                            recommendation.id?.let {
                                onItemClick(recommendation.id!!)
                            }
                        }
                    )
                }
            }
        },
        showSeeAllContent = false,
    )
}

@Preview
@Composable
fun RecommendationsPrev() {
    MoviesTheme {
        CompositionLocalProvider(LocalWindowWidthSizeClass provides WindowWidthSizeClass.Compact) {
            Recommendations(
                recommendations = listOf(
                    Recommendation(name = "Lorem Ipsum", image = "", score = 0.6f),
                    Recommendation(name = "Lorem Ipsum", image = "", score = 0.8f),
                    Recommendation(name = "Lorem Ipsum", image = "", score = 0.7f),
                    Recommendation(name = "Lorem Ipsum", image = "", score = 0.1f),
                ),
                scoreColor = Color.Green,
                onItemClick = {}
            )
        }
    }
}