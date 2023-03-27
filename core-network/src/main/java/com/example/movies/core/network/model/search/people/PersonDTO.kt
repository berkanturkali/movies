package com.example.movies.core.network.model.search.people


import com.example.movies.core.network.model.base.BaseDTO
import com.squareup.moshi.Json

data class PersonDTO(
    @Json(name = "adult")
    val adult: Boolean? = null,
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "known_for")
    val knownFor: List<KnownForDTO>? = null,
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "popularity")
    val popularity: Double? = null,
    @Json(name = "profile_path")
    val profilePath: String? = null
) : BaseDTO()