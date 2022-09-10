package com.example.movies.core.network.trending

/**
 * Represents the media type for trending path
 */
enum class TrendingMediaType(val type: String) {

    ALL("all"),
    MOVIE("movie"),
    TV("tv"),
    PERSON("person")
}