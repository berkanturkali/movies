package com.example.movies.core.network.model.toprated

import com.squareup.moshi.Json

data class TopRatedMoviesResponseDTO(
    @Json(name = "results")
    val topRatedMovies: List<TopRatedMovieDTO>
)