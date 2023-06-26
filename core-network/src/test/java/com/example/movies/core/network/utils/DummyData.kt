package com.example.movies.core.network.utils

import com.example.movies.core.network.model.moviedetails.GenreDTO
import com.example.movies.core.network.model.moviedetails.MovieDetailsResponseDTO
import com.example.movies.core.network.model.moviedetails.SpokenLanguageDTO
import com.example.movies.core.network.model.nowplaying.NowPlayingMovieDTO
import com.example.movies.core.network.model.search.collection.CollectionDTO
import com.example.movies.core.network.model.search.company.CompanyDTO
import com.example.movies.core.network.model.search.movie.MovieDTO
import com.example.movies.core.network.model.search.people.PersonDTO
import com.example.movies.core.network.model.search.tvshow.TvShowDTO
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

    val collectionDTO = CollectionDTO(
        id = 9485,
        backdropPath = "/z5A5W3WYJc3UVEWljSGwdjDgQ0j.jpg",
        name = "The Fast and the Furious Collection",
        posterPath = "/uv63yAGg1zETAs1XQsOQpava87l.jpg"
    )

    val movieDTO = MovieDTO(
        id = 24428,
        posterPath = "/cezWGskPY5x7GaglTTRN4Fugfb8.jpg",
        adult = false,
        overview = "When an unexpected enemy emerges and threatens global safety and security, Nick Fury, director of the international peacekeeping agency known as S.H.I.E.L.D., finds himself in need of a team to pull the world back from the brink of disaster. Spanning the globe, a daring recruitment effort begins!",
        releaseDate = "2012-04-25",
        genreIds = listOf(878, 28, 12),
        originalLanguage = "en",
        originalTitle = "The Avengers",
        title = "The Avengers",
        backdropPath = "/hbn46fQaRmlpBuUrEiFqv0GDL6Y.jpg",
        popularity = 7.35321,
        voteCount = 8503,
        video = false,
        voteAverage = 7.33
    )

    val personDTO = PersonDTO(
        profilePath = "/2daC5DeXqwkFND0xxutbnSVKN6c.jpg",
        adult = false,
        id = 51329,
        knownFor = emptyList(),
        name = "Brandley Cooper",
        popularity = 6.431053
    )

    val tvShowDTO = TvShowDTO(
        id = 1399,
        posterPath = "/cezWGskPY5x7GaglTTRN4Fugfb8.jpg",
        overview = "When an unexpected enemy emerges and threatens global safety and security, Nick Fury, director of the international peacekeeping agency known as S.H.I.E.L.D., finds himself in need of a team to pull the world back from the brink of disaster. Spanning the globe, a daring recruitment effort begins!",
        genreIds = listOf(10765, 10759, 18),
        originalLanguage = "en",
        backdropPath = "/hbn46fQaRmlpBuUrEiFqv0GDL6Y.jpg",
        popularity = 7.35321,
        voteCount = 8503,
        originCountry = listOf("US"),
        voteAverage = 7.91,
        firstAirDate = "2011-04-17",
        name = "Game of Thrones",
        originalName = "Game of Thrones"
    )
    val movieDetailsResponseDTO = MovieDetailsResponseDTO(
        title = "Spider-Man: Across the Spider-Verse",
        posterPath = "/8Vt6mWEReuy4Of61Lnj5Xj704m8.jpg",
        releaseDate = "2023-05-31",
        spokenLanguages = listOf(
            SpokenLanguageDTO(
                englishName = "English",
                iso6391 = "en",
                name = "English"
            )
        ),
        tagline = "It's how you wear the mask that matters",
        genres = listOf(
            GenreDTO(
                id = 28,
                name = "Action",
            ),
            GenreDTO(
                id = 12,
                name = "Adventure"
            )
        ),
        voteAverage = 8.656,
        status = "Released"
    )
    //endregion
}