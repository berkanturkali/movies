package com.example.movies.core.network.mapper.moviedetails

import com.example.movies.core.model.moviedetails.Video
import com.example.movies.core.model.video.Site
import com.example.movies.core.model.video.YoutubeThumbnailQuality
import com.example.movies.core.network.mapper.base.RemoteResponseModelMapper
import com.example.movies.core.network.model.moviedetails.VideoDTO
import timber.log.Timber
import javax.inject.Inject

class VideoMapper @Inject constructor() : RemoteResponseModelMapper<VideoDTO, Video> {

    companion object {
        const val YOUTUBE_THUMBNAIL_BASE_URL = "http://img.youtube.com/vi/"
        const val YOUTUBE_URL = "https://www.youtube.com/watch?v="
        const val VIMEO_URL = "https://vimeo.com/"
    }

    override fun mapFromModel(model: VideoDTO): Video {
        return Video(
            url = model.key?.let {
                mapUrl(model.site, model.key)
            },
            thumbnail = model.key?.let {
                getThumbnailBySite(model.site, model.key)
            }
        )
    }

    private fun mapUrl(site: String?, key: String): String? {
        return site?.let {
            val baseUrl = getBaseUrlBySite(it)
            baseUrl + key
        }
    }

    private fun getThumbnailBySite(site: String?, key: String): String? {
        return site?.let {
            if (site == Site.YOUTUBE.site) {
                Timber.d(
                    YOUTUBE_THUMBNAIL_BASE_URL + key + "/${YoutubeThumbnailQuality.HQDEFAULT.quality}"
                )
                YOUTUBE_THUMBNAIL_BASE_URL + key + "/${YoutubeThumbnailQuality.HQDEFAULT.quality}"
            } else {
                null
            }
        }
    }

    private fun getBaseUrlBySite(site: String): String? {
        return when (site) {
            Site.YOUTUBE.site -> {
                YOUTUBE_URL
            }
            Site.VIMEO.site -> {
                VIMEO_URL
            }
            else -> null
        }
    }


}