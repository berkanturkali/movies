package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.movies.core.model.moviedetails.Reviews
import com.example.movies.feature.details.R

@Composable
fun Reviews(
    reviews: Reviews,
    modifier: Modifier = Modifier
) {
    reviews.reviews?.let { list ->
        if (list.isNotEmpty()) {
            val topThreeReviews = list.take(3)
            val pagerState = rememberPagerState(initialPage = 0)
            DetailsListSection(
                sectionTitleId = R.string.reviews_title,
                content = {
                    HorizontalPager(
                        pageCount = topThreeReviews.size,
                        state = pagerState
                    ) { page ->
                        val reviewItem = topThreeReviews[page]
                        ReviewItem(
                            image = reviewItem.reviewerImage,
                            userName = reviewItem.reviewerName,
                            date = reviewItem.reviewDate,
                            review = reviewItem.review,
                            rating = reviewItem.rating,
                            pagerState = pagerState,
                            page = page
                        )
                    }
                },
                showSeeAllContent = reviews.reviewCount != null && reviews.reviewCount!! > topThreeReviews.size,
                modifier = modifier,
                count = reviews.reviewCount
            )
        }
    }
}