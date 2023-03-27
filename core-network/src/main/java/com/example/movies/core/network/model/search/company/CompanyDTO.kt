package com.example.movies.core.network.model.search.company

import com.example.movies.core.network.model.base.BaseDTO
import com.squareup.moshi.Json

data class CompanyDTO(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "logo_path")
    val logoPath: String? = null,
    @Json(name = "name")
    val name: String? = null
) : BaseDTO()