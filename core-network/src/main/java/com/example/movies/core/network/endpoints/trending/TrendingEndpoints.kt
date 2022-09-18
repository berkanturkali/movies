package com.example.movies.core.network.endpoints.trending

/**
 * Trending-related endpoints that The Movie Database API provides.
 */
object TrendingEndpoints {

    private const val TRENDING_PATH = "trending"

    const val MEDIA_TYPE_PATH = "media_type"

    const val TIME_WINDOW_PATH = "time_window"


    const val TRENDING_ENDPOINT = "$TRENDING_PATH/{$MEDIA_TYPE_PATH}/{$TIME_WINDOW_PATH}"
}