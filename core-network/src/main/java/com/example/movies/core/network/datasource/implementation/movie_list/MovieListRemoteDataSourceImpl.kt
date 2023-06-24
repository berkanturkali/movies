package com.example.movies.core.network.datasource.implementation.movie_list

import com.example.movies.core.network.datasource.abstraction.movie_list.MovieListRemoteDataSource
import com.example.movies.core.network.model.nowplaying.NowPlayingResponseDTO
import com.example.movies.core.network.model.popular.PopularMoviesResponseDTO
import com.example.movies.core.network.model.top_rated.TopRatedMoviesResponseDTO
import com.example.movies.core.network.model.upcoming.UpcomingMoviesResponseDTO
import com.example.movies.core.network.service.movie_list.MovieListService
import retrofit2.Response
import javax.inject.Inject

class MovieListRemoteDataSourceImpl @Inject constructor(
    private val service: MovieListService
) : MovieListRemoteDataSource {
    override suspend fun fetchTopRatedMovies(): Response<TopRatedMoviesResponseDTO> {
        return service.fetchTopRatedMovies()
    }

    override suspend fun fetchPopularMovies(): Response<PopularMoviesResponseDTO> {
        return service.fetchPopularMovies()
    }

    override suspend fun fetchUpcomingMovies(): Response<UpcomingMoviesResponseDTO> {
        return service.fetchUpcomingMovies()
    }

    override suspend fun fetchNowPlayingMovies(): Response<NowPlayingResponseDTO> {
        return service.fetchNowPlayingMovies()
    }
}