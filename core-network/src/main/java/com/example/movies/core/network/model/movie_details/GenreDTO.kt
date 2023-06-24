package com.example.movies.core.network.model.movie_details


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class GenreDTO(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val name: String? = null
)