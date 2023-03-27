package com.example.movies.core.network.model.search.movie


import com.squareup.moshi.Json

data class MoviesResponseDTO(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val results: List<MovieDTO?>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)