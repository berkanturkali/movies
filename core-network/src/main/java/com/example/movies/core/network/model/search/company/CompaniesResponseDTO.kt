package com.example.movies.core.network.model.search.company

import com.squareup.moshi.Json

data class CompaniesResponseDTO(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val companies: List<CompanyDTO>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)