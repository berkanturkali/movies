package com.example.movies.core.network.service.movie_list

import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.endpoints.movies.MoviesEndpoints
import com.example.movies.core.network.model.nowplaying.NowPlayingResponseDTO
import com.example.movies.core.network.model.popular.PopularMoviesResponseDTO
import com.example.movies.core.network.model.top_rated.TopRatedMoviesResponseDTO
import com.example.movies.core.network.model.upcoming.UpcomingMoviesResponseDTO
import com.example.movies.core.network.service.base.BaseService
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieListService : BaseService {

    @GET(MoviesEndpoints.NOW_PLAYING_MOVIES_ENDPOINT)
    suspend fun fetchNowPlayingMovies(
        @Query("page") page: Int = 1,
    ): Response<NowPlayingResponseDTO>

    @GET(MoviesEndpoints.UPCOMING_MOVIES_ENDPOINT)
    suspend fun fetchUpcomingMovies(
        @Query("page") page: Int = 1,
    ): Response<UpcomingMoviesResponseDTO>

    @GET(MoviesEndpoints.POPULAR_MOVIES_ENDPOINT)
    suspend fun fetchPopularMovies(
        @Query("page") page: Int = 1,
    ): Response<PopularMoviesResponseDTO>

    @GET(MoviesEndpoints.TOP_RATED_MOVIES_ENDPOINT)
    suspend fun fetchTopRatedMovies(
        @Query("page") page: Int = 1,
    ): Response<TopRatedMoviesResponseDTO>

}