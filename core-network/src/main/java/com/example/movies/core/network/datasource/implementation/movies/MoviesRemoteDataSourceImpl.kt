package com.example.movies.core.network.datasource.implementation.movies

import com.example.movies.core.network.datasource.abstraction.movies.MoviesRemoteDataSource
import com.example.movies.core.network.model.movie_details.MovieDetailsResponseDTO
import com.example.movies.core.network.model.nowplaying.NowPlayingResponseDTO
import com.example.movies.core.network.model.popular.PopularMoviesResponseDTO
import com.example.movies.core.network.model.top_rated.TopRatedMoviesResponseDTO
import com.example.movies.core.network.model.upcoming.UpcomingMoviesResponseDTO
import com.example.movies.core.network.service.movies.MoviesService
import retrofit2.Response
import javax.inject.Inject

class MoviesRemoteDataSourceImpl @Inject constructor(
    private val service: MoviesService
) : MoviesRemoteDataSource {

    override suspend fun fetchMovie(id: Int): Response<MovieDetailsResponseDTO> {
        return service.fetchMovie(id)
    }
}