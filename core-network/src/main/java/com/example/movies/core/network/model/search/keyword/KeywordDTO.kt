package com.example.movies.core.network.model.search.keyword


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class KeywordDTO(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val name: String? = null
)