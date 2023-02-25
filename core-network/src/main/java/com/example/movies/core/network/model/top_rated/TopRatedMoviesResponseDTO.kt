package com.example.movies.core.network.model.top_rated

import com.squareup.moshi.Json

data class TopRatedMoviesResponseDTO(
    @Json(name = "results")
    val topRatedMovies: List<TopRatedMovieDTO>
)