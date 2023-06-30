package com.example.movies.core.network.model.moviedetails


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class RecommendationsResponseDTO(
    @Json(name = "page")
    val page: Int? = null,
    @Json(name = "results")
    val results: List<RecommendationDTO?>? = null,
    @Json(name = "total_pages")
    val totalPages: Int? = null,
    @Json(name = "total_results")
    val totalResults: Int? = null
)