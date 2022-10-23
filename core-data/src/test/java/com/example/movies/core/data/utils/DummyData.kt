package com.example.movies.core.data.utils

import com.example.movies.core.network.model.nowplaying.DatesDTO
import com.example.movies.core.network.model.nowplaying.NowPlayingMovieDTO
import com.example.movies.core.network.model.nowplaying.NowPlayingResponseDTO
import com.example.movies.core.network.model.trending.TrendingDTO
import com.example.movies.core.network.model.trending.TrendingResponseDTO

object DummyData {

    //region network models
    private val trendingDto = TrendingDTO(
        id = 1,
        title = "Lou",
        posterPath = "/djM2s4wSaATn4jVB33cV05PEbV7.jpg",
        overview = "A young girl is kidnapped during a powerful storm. Her mother joins forces with her mysterious neighbour to set off in pursuit of the kidnapper. Their journey will test their limits and expose the dark secrets of their past"
    )


    val trendingResponseDTO = TrendingResponseDTO(
        page = 1,
        trendingMovies = listOf(trendingDto),
        totalPages = 1000,
        totalResults = 20000,
    )

    val nowPlayingDTO = NowPlayingMovieDTO(
        id = 436270,
        title = "Black Adam",
        overview = "Nearly 5,000 years after he was bestowed with the almighty powers of the Egyptian gods—and imprisoned just as quickly—Black Adam is freed from his earthly tomb, ready to unleash his unique form of justice on the modern world.",
        posterPath = "/3zXceNTtyj5FLjwQXuPvLYK5YYL.jpg"
    )

    val nowPlayingResponseDTO = NowPlayingResponseDTO(
        dates = DatesDTO("", ""),
        page = 1,
        results = listOf(nowPlayingDTO),
        total_pages = 1000,
        total_results = 20000,
    )
    //endregion
}