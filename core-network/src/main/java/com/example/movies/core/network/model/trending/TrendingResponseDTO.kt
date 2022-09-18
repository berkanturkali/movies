package com.example.movies.core.network.model.trending

import com.squareup.moshi.Json

data class TrendingResponseDTO(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val trendingMovies: List<TrendingDTO>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)