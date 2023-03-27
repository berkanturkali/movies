package com.example.movies.core.network.model.search.keyword


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class KeywordsResponseDTO(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val results: List<KeywordDTO>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)