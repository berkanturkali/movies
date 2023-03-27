package com.example.movies.core.network.model.base

import com.squareup.moshi.Json

abstract class BasePagingResponseDTO(
    @Json(name = "page")
    val page: Int? = null,
    @Json(name = "total_pages")
    val totalPages: Int? = null,
    @Json(name = "total_results")
    val totalResults: Int? = null,
)