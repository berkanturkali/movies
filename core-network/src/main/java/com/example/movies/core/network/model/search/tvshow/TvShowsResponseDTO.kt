package com.example.movies.core.network.model.search.tvshow


import com.squareup.moshi.Json

data class TvShowsResponseDTO(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val results: List<TvShowDTO>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)