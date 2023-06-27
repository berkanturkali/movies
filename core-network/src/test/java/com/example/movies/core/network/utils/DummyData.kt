package com.example.movies.core.network.utils

import com.example.movies.core.network.model.credit.CastDTO
import com.example.movies.core.network.model.moviedetails.GenreDTO
import com.example.movies.core.network.model.moviedetails.MovieDetailsResponseDTO
import com.example.movies.core.network.model.moviedetails.SpokenLanguageDTO
import com.example.movies.core.network.model.nowplaying.NowPlayingMovieDTO
import com.example.movies.core.network.model.review.AuthorDetailsDTO
import com.example.movies.core.network.model.review.ReviewDTO
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
        status = "Released",
        overview = "After reuniting with Gwen Stacy, Brooklyn’s full-time, friendly neighborhood" +
                " Spider-Man is catapulted across the Multiverse," +
                " where he encounters the Spider Society, a team of Spider-People charged with" +
                " protecting the Multiverse’s very existence." +
                " But when the heroes clash on how to handle a new threat," +
                " Miles finds himself pitted against the other Spiders and must " +
                "set out on his own to save those he loves most.",
        revenue = 512609552
    )

    val castDTO = CastDTO(
        adult = false,
        gender = 2,
        id = 587506,
        knownForDepartment = "Acting",
        name = "Shameik Moore",
        originalName = "Shameik Moore",
        popularity = 21.558,
        profilePath = "/uJNaSTsfBOvtFWsPP23zNthknsB.jpg",
        castId = 705,
        character = "Miles Morales / Spider-Man (voice)",
        creditId = "1232131231232131",
        order = 0
    )

    val reviewDTO = ReviewDTO(
        author = "garethmb",
        authorDetails = AuthorDetailsDTO(
            name = "",
            username = "garethmb",
            avatarPath = "/https://secure.gravatar.com/avatar/3593437cbd05cebe0a4ee753965a8ad1.jpg",
            rating = 8.0
        ),
        content = "Life as a teenager is never easy and when you are gifted with the superhuman abilities of a spider and lead a " +
                "double life as a student and crime fighter; life gets even harder.\r\n\r\nMiles Morales (Shameik Moore) is finding it" +
                " even harder to hide his secret from his family who has grown concerned that his erratic behavior is more than" +
                " the usual teenage angst.\r\n\r\nIn another earth, Gwen Stacy (Hailee Steinfeld) deals with her Police officer" +
                " father desperately hunting down her alter-ego believing that she is a killer which drives a wedge " +
                "between them as Gwen desperately tries to find her way forward.\r\n\r\nIn “Spider-Man Across the Spider-Verse" +
                " audiences learn that what one perceives as reality is often just the corner of a much larger picture and when Miles" +
                " confronts what he dismisses as a “Villain of the Week” in a quirky enemy known as The Spot (Jason Schwartzman), starts a" +
                " campaign against Spider-Man, he soon finds that the threat is much larger than he expected and secretly follows a visiting " +
                "Gwen into an another Earth where his actions soon draw the attention of a larger temporal Spider squad.\r\n\r\nMotivated by " +
                "his feelings for Gwen and a desire to do good, Miles looks to undo the damage that the Spot is causing across various Earths" +
                " and learns that each one has its own version of Spider-man or Woman to protect it.\r\n\r\nAt this point the film goes into" +
                " overdrive as Miles learns more about his past and how he became Spider-Man but also learns more about the cost that " +
                "his powers enact on his life and those around him. There are plenty of special moments and guest appearances that follow " +
                "from the more obscure to the mainstream and the range of emotions from the audience at the press screening as they reacted " +
                "to the film showed they were deeply engaged and loving it.\r\n\r\nThe film does take a darker turn and does end in a" +
                " cliffhanger which sets up the next film very well but also may be a bit darker than younger viewers might want. " +
                "That being said; I enjoyed this film far more than I did the prior film. I found the animation style a bit off-putting" +
                " as the jerky way the characters moved was a bit much over the length of a feature film. This time around there is" +
                " a mix of animation styles throughout and at times in the same frame which may be a bit hard for some as the film does" +
                " come at the viewer with waves of flashing lights, sounds, and animations that very cleverly mimic reading a comic" +
                " complete with small boxes to define various characters from time to time.\r\n\r\nThe film runs nearly two and" +
                " a half hours and did seem to go on a bit long at times but thanks to the great voice-acting and strong cast " +
                "as well as engaging storyline I found myself eagerly looking forward to the next film.\r\n\r\nI first saw " +
                "a rough cut of a scene at Cinemacon in 2022 and it was amazing seeing the final scene near the opening of the film" +
                " as it was a rare instance of a film surpassing expectations and delivers the storyline and action" +
                " with a good dose of solid characters that fans will love.\r\n\r\n4.5 stars out of 5",
        createdAt = "2023-05-31T14:58:50.182Z",
        id = "647760aad3719700f9cad266",
        updatedAt = "2023-05-31T14:58:50.267Z",
        url = "https://www.themoviedb.org/review/647760aad3719700f9cad266"
    )
    //endregion
}