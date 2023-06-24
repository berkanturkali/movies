package com.example.movies.core.network.model.movie_details


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

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