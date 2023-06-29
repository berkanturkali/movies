package com.example.movies.core.network.model.moviedetails


import com.squareup.moshi.Json

data class KeywordDTO(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val name: String? = null
)