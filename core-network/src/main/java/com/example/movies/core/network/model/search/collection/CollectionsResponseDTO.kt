package com.example.movies.core.network.model.search.collection


import com.squareup.moshi.Json

data class CollectionsResponseDTO(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val results: List<CollectionDTO>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int,
)