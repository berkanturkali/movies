package com.example.movies.core.network.model.moviedetails


import com.squareup.moshi.Json

data class ProductionCountryDTO(
    @Json(name = "iso_3166_1")
    val iso31661: String? = null,
    @Json(name = "name")
    val name: String? = null
)