package com.example.movies.core.network.model.credit


import com.squareup.moshi.Json

data class CastDTO(
    @Json(name = "adult")
    val adult: Boolean? = null,
    @Json(name = "cast_id")
    val castId: Int? = null,
    @Json(name = "character")
    val character: String? = null,
    @Json(name = "credit_id")
    val creditId: String? = null,
    @Json(name = "gender")
    val gender: Int? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "known_for_department")
    val knownForDepartment: String? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "order")
    val order: Int? = null,
    @Json(name = "original_name")
    val originalName: String? = null,
    @Json(name = "popularity")
    val popularity: Double? = null,
    @Json(name = "profile_path")
    val profilePath: String? = null
)