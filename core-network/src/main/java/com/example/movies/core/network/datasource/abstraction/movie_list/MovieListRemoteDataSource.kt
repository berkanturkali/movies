package com.example.movies.core.network.datasource.abstraction.movie_list

import com.example.movies.core.network.model.nowplaying.NowPlayingResponseDTO
import com.example.movies.core.network.model.popular.PopularMoviesResponseDTO
import com.example.movies.core.network.model.top_rated.TopRatedMoviesResponseDTO
import com.example.movies.core.network.model.upcoming.UpcomingMoviesResponseDTO
import retrofit2.Response

interface MovieListRemoteDataSource {

    suspend fun fetchTopRatedMovies(): Response<TopRatedMoviesResponseDTO>

    suspend fun fetchPopularMovies(): Response<PopularMoviesResponseDTO>

    suspend fun fetchUpcomingMovies(): Response<UpcomingMoviesResponseDTO>

    suspend fun fetchNowPlayingMovies(): Response<NowPlayingResponseDTO>
}