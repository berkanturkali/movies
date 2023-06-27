package com.example.movies.core.network.model.review


import com.squareup.moshi.Json

data class ReviewsResponseDTO(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "page")
    val page: Int? = null,
    @Json(name = "results")
    val results: List<ReviewDTO>,
    @Json(name = "total_pages")
    val totalPages: Int? = null,
    @Json(name = "total_results")
    val totalResults: Int? = null
)