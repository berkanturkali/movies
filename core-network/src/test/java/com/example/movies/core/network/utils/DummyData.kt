package com.example.movies.core.network.utils

import com.example.movies.core.network.model.trending.TrendingDTO

object DummyData {

    //region network models

    val trendingDto = TrendingDTO(
        id = 1,
        title = "Lou",
        posterPath = "/djM2s4wSaATn4jVB33cV05PEbV7.jpg",
        overview = "A young girl is kidnapped during a powerful storm. Her mother joins forces with her mysterious neighbour to set off in pursuit of the kidnapper. Their journey will test their limits and expose the dark secrets of their past"
    )

    //endregion
}