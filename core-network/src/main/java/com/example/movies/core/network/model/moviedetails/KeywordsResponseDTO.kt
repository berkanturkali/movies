package com.example.movies.core.network.model.moviedetails


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class KeywordsResponseDTO(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "keywords")
    val keywords: List<KeywordDTO?>? = null
)