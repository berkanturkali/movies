package com.example.movies.core.network.model.search.movie


import com.example.movies.core.network.model.base.BasePagingResponseDTO
import com.squareup.moshi.Json

data class MoviesResponseDTO(
    @Json(name = "results")
    val results: List<MovieDTO>,
) : BasePagingResponseDTO()