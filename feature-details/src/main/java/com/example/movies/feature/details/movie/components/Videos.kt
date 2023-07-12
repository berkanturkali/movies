package com.example.movies.feature.details.movie.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movies.core.model.moviedetails.Video
import com.example.movies.feature.details.R

@Composable
fun Videos(
    videos: List<Video>,
    onVideoClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    DetailsListSection(
        modifier = modifier,
        sectionTitleId = R.string.videos_title,
        content = {
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
        })

}