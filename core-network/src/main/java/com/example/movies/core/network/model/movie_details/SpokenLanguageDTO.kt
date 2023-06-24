package com.example.movies.core.network.model.movie_details


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class SpokenLanguageDTO(
    @Json(name = "english_name")
    val englishName: String? = null,
    @Json(name = "iso_639_1")
    val iso6391: String? = null,
    @Json(name = "name")
    val name: String? = null
)