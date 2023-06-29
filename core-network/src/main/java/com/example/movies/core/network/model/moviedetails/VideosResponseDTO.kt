package com.example.movies.core.network.model.moviedetails


import com.squareup.moshi.Json

data class VideosResponseDTO(
    @Json(name = "id")
    val id: Int? = null,
    @Json(name = "results")
    val results: List<VideoDTO?>? = null
)