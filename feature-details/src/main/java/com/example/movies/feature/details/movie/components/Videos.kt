package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movies.core.model.moviedetails.Video
import com.example.movies.feature.details.R
import timber.log.Timber

@Composable
fun Videos(
    videos: List<Video>,
    onVideoClick: (String) -> Unit,
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
                titleId = R.string.videos_title,
            )
        }

        LazyRow(
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(videos) { video ->
                TrailerThumbnail(
                    thumbnail = video.thumbnail,
                    onThumbnailClick = {
                        video.url?.let {
                            onVideoClick(it)
                        }
                    },
                )
            }
        }
    }
}