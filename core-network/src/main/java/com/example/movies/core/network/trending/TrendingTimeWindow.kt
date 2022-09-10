package com.example.movies.core.network.trending

/**
 * Represents the time_window param for trending path
 */
enum class TrendingTimeWindow(val timeWindow: String) {

    DAY("day"),
    WEEK("week")
}