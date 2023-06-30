package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movies.core.model.moviedetails.Reviews
import com.example.movies.feature.details.R

@Composable
fun Reviews(
    reviews: Reviews,
    modifier: Modifier = Modifier
) {
    reviews.reviews?.let { list ->
        val pagerState = rememberPagerState(initialPage = 0)
        Column(modifier = modifier) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                SectionTitle(
                    titleId = R.string.reviews_title,
                )
                Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    SeeAllButton(onItemClick = {})
                    reviews.reviewCount?.let { count ->
                        Text(
                            text = "($count)",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                    }
                }
            }
            HorizontalPager(
                pageCount = list.size,
                state = pagerState
            ) {
                val reviewItem = list[it]
                ReviewItem(
                    image = reviewItem.reviewerImage,
                    userName = reviewItem.reviewerName,
                    date = reviewItem.reviewDate,
                    review = reviewItem.review,
                    rating = reviewItem.rating
                )
            }
        }
    }
}