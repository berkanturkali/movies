package com.example.movies.feature.details.movie.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.examle.movies.core.ui.theme.MoviesTheme
import kotlin.math.absoluteValue

@Composable
fun ReviewItem(
    image: String?,
    userName: String?,
    date: String?,
    rating: String?,
    review: String?,
    pagerState: PagerState,
    page: Int,
    modifier: Modifier = Modifier,
    firstLetter: String? = userName?.first()
        ?.uppercase(),
) {

    val pageOffset =
        ((pagerState.currentPage) - page + pagerState.currentPageOffsetFraction).absoluteValue

    val size by animateFloatAsState(
        targetValue = if (pageOffset != 0.0f) 0.9f else 1f,
        animationSpec = tween(durationMillis = 200)
    )
    OutlinedCard(
        modifier = modifier
            .padding(horizontal = 12.dp)
            .graphicsLayer {
                scaleX = size
                scaleY = size
                alpha = lerp(
                    start = 0.5f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                )
            },
        border = BorderStroke(
            0.5.dp, color = MaterialTheme.colorScheme.onSurface
        ),
        elevation = CardDefaults.outlinedCardElevation(
            defaultElevation = 8.dp
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(250.dp)
                .background(color = MaterialTheme.colorScheme.surface)
                .padding(vertical = 8.dp, horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            ReviewItemUserImage(image = image, firstLetter = firstLetter)
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
            ) {

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    ReviewItemUserName(name = userName)
                    ReviewItemRating(rating = rating)
                }

                ReviewItemDate(date = date)

                ReviewItemReview(review = review)

            }

        }

    }
}

@Preview
@Composable
fun ReviewItemPrev() {
    MoviesTheme {
        ReviewItem(
            image = "", userName = "MovieGuys", date = "June 22, 2023",
            review = "Secret Invasion is rather what I have come to " +
                    "expect from US entertainment these days, that is, not a lot.\n" +
                    "\n" +
                    "Take yet another formulaic story, vaguely " +
                    "reminiscent of Invasion of the Body Snatchers, throw in" +
                    " a dash of \"watch out for those Russian's\" sentiment, lots of" +
                    " special effects, that are admittedly, well done and parachute" +
                    " in a reasonably well known actor or two and hope it all works.\n",
            rating = "5",
            pagerState = rememberPagerState(initialPage = 0),
            page = 1
        )
    }
}