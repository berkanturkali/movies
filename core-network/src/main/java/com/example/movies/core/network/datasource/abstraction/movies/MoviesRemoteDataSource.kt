package com.example.movies.core.network.datasource.abstraction.movies

import com.example.movies.core.network.model.movie_details.MovieDetailsResponseDTO
import com.example.movies.core.network.model.nowplaying.NowPlayingResponseDTO
import com.example.movies.core.network.model.popular.PopularMoviesResponseDTO
import com.example.movies.core.network.model.top_rated.TopRatedMoviesResponseDTO
import com.example.movies.core.network.model.upcoming.UpcomingMoviesResponseDTO
import retrofit2.Response

interface MoviesRemoteDataSource {

    suspend fun fetchMovie(id: Int): Response<MovieDetailsResponseDTO>
}