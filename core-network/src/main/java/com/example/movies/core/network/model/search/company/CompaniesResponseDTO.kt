package com.example.movies.core.network.model.search.company

import com.example.movies.core.network.model.base.BasePagingResponseDTO
import com.squareup.moshi.Json

data class CompaniesResponseDTO(
    @Json(name = "results")
    val companies: List<CompanyDTO>,
) : BasePagingResponseDTO()