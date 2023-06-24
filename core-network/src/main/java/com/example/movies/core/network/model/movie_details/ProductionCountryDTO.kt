package com.example.movies.core.network.model.movie_details


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class ProductionCountryDTO(
    @Json(name = "iso_3166_1")
    val iso31661: String? = null,
    @Json(name = "name")
    val name: String? = null
)