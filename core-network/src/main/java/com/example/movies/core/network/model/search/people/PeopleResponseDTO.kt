package com.example.movies.core.network.model.search.people


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class PeopleResponseDTO(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val results: List<PersonDTO>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)