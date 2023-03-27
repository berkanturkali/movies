package com.example.movies.core.network.model.search.collection


import com.example.movies.core.network.model.base.BaseDTO
import com.squareup.moshi.Json

data class CollectionDTO(
    @Json(name = "backdrop_path")
    val backdropPath: String? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "poster_path")
    val posterPath: String? = null
) : BaseDTO()