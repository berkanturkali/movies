package com.example.movies.core.network.model.moviedetails


import com.squareup.moshi.Json

data class SpokenLanguageDTO(
    @Json(name = "english_name")
    val englishName: String? = null,
    @Json(name = "iso_639_1")
    val iso6391: String? = null,
    @Json(name = "name")
    val name: String? = null
)