package com.example.movies.core.network.model.search.people


import com.example.movies.core.network.model.base.BasePagingResponseDTO
import com.squareup.moshi.Json

data class PeopleResponseDTO(
    @Json(name = "results")
    val people: List<PersonDTO>,
) : BasePagingResponseDTO()