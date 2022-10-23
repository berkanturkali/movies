package com.example.movies.core.network.model.upcoming

import com.squareup.moshi.Json

data class UpcomingMoviesResponseDTO(
    @Json(name = "dates")
    val dates: DatesDTO,
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val upcomingMovies: List<UpcomingMovieDTO>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)