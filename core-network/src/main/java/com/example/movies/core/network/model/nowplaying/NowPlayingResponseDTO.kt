package com.example.movies.core.network.model.nowplaying

@Suppress("ConstructorParameterNaming")
data class NowPlayingResponseDTO(
    val dates: DatesDTO,
    val page: Int,
    val results: List<NowPlayingMovieDTO>,
    val total_pages: Int,
    val total_results: Int
)