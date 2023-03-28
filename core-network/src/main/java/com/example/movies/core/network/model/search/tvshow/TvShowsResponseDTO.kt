package com.example.movies.core.network.model.search.tvshow


import com.example.movies.core.network.model.base.BasePagingResponseDTO
import com.squareup.moshi.Json

data class TvShowsResponseDTO(
    @Json(name = "results")
    val shows: List<TvShowDTO>,
) : BasePagingResponseDTO()