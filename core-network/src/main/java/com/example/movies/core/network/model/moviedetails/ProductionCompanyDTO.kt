package com.example.movies.core.network.model.moviedetails


import com.squareup.moshi.Json

data class ProductionCompanyDTO(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "logo_path")
    val logoPath: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "origin_country")
    val originCountry: String? = null
)