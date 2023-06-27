package com.example.movies.core.network.model.review


import com.squareup.moshi.Json

data class AuthorDetailsDTO(
    @Json(name = "avatar_path")
    val avatarPath: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "rating")
    val rating: Double? = null,
    @Json(name = "username")
    val username: String? = null
)