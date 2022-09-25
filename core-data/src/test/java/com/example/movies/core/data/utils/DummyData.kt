package com.example.movies.core.data.utils

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
    //endregion
}