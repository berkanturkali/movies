package com.example.movies.core.network.model.popular

import com.squareup.moshi.Json

data class PopularMoviesResponseDTO(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val popularMovies: List<PopularMovieDTO>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)