package com.example.movies.core.network.model.credit


import com.squareup.moshi.Json

data class CreditsResponseDTO(
    @Json(name = "cast")
    val cast: List<CastDTO?>? = null,
)