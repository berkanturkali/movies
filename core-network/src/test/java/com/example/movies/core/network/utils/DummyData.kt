package com.example.movies.core.network.utils

import com.example.movies.core.network.model.nowplaying.NowPlayingMovieDTO
import com.example.movies.core.network.model.search.company.CompanyDTO
import com.example.movies.core.network.model.trending.TrendingDTO
import com.example.movies.core.network.model.trending.TrendingResponseDTO
import com.example.movies.core.network.model.upcoming.UpcomingMovieDTO

object DummyData {

    //region network models
    val trendingDto = TrendingDTO(
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

    val upcomingMovieDTO = UpcomingMovieDTO(
        id = 366672,
        overview = "A hard-on-his-luck hound finds himself in a town full of cats in need of a hero to defend them from a ruthless villain's wicked plot to wipe their village off the map. With help from a reluctant mentor, our underdog must assume the role of town samurai and team up with the villagers to save the day.",
        posterPath = "/wMDUDwAArpfGdtTTZ25SfwngGwt.jpg",
        title = "The Quintessential Quintuplets Movie",
    )

    val companyDTO = CompanyDTO(
        id = 34,
        logoPath = "/GagSvqWlyPdkFHMfQ3pNq6ix9P.png",
        name = "Sony Pictures"
    )
    //endregion
}