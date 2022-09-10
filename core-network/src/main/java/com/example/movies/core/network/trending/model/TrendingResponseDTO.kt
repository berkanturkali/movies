package com.example.movies.core.network.trending.model

import com.squareup.moshi.Json

data class TrendingResponseDTO(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val trendingMovies: List<Any>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)