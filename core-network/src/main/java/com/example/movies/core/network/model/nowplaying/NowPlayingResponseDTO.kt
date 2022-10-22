package com.example.movies.core.network.model.nowplaying

data class NowPlayingResponseDTO(
    val datesDTO: DatesDTO,
    val page: Int,
    val nowPlayingMovies: List<NowPlayingMovieDTO>,
    val total_pages: Int,
    val total_results: Int
)