package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movies.feature.details.R

@Composable
fun Reviews(
    reviewerImage: String?,
    reviewDate: String?,
    reviewerName: String?,
    review: String?,
    reviewerRating: String?,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
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
                date = reviewDate,
                review = review,
                rating = reviewerRating
            )
        }
    }
}