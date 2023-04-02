package com.example.movies.core.network.mapper.poster

import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.model.ImageSizes
import javax.inject.Inject

class ImagePathMapper @Inject constructor() {

    fun mapPath(path: String?): String? {
        return path?.let {
            "${BuildConfig.BASE_IMAGE_URL}/${ImageSizes.ORIGINAL}${path}"
        }
    }
}