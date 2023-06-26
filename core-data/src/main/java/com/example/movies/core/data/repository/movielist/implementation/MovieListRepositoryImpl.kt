package com.example.movies.core.data.repository.movielist.implementation

import com.example.movies.core.common.Resource
import com.example.movies.core.common.executor.abstraction.ExecutorThread
import com.example.movies.core.data.repository.movielist.abstraction.MovieListRepository
import com.example.movies.core.data.utils.safeApiCall
import com.example.movies.core.model.home.NowPlayingMovie
import com.example.movies.core.model.home.PopularMovie
import com.example.movies.core.model.home.TopRatedMovie
import com.example.movies.core.model.home.UpcomingMovie
import com.example.movies.core.network.datasource.abstraction.movielist.MovieListRemoteDataSource
import com.example.movies.core.network.mapper.nowplaying.NowPlayingMoviesResponseMapper
import com.example.movies.core.network.mapper.popular.PopularMovieMapper
import com.example.movies.core.network.mapper.toprated.TopRatedMovieMapper
import com.example.movies.core.network.mapper.upcoming.UpcomingMovieMapper
import com.example.movies.core.network.model.upcoming.UpcomingMoviesResponseDTO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(
    private val nowPlayingMoviesResponseMapper: NowPlayingMoviesResponseMapper,
    private val popularMovieMapper: PopularMovieMapper,
    private val topRatedMoviesMapper: TopRatedMovieMapper,
    private val upcomingMovieMapper: UpcomingMovieMapper,
    private val remoteDataSource: MovieListRemoteDataSource,
    private val executorThread: ExecutorThread,
) : MovieListRepository {

    override suspend fun fetchNowPlayingMovies(): Flow<Resource<List<NowPlayingMovie>>> {
        return safeApiCall(
            mapFromModel = { model ->
                nowPlayingMoviesResponseMapper.mapFromModelList(model.results)
            },
            executorThread = executorThread.io,
        ) {
            remoteDataSource.fetchNowPlayingMovies()
        }
    }

    override suspend fun fetchPopularMovies(): Flow<Resource<List<PopularMovie>>> {
        return safeApiCall(mapFromModel = { popularMoviesResponse ->
            popularMovieMapper.mapFromModelList(popularMoviesResponse.popularMovies)
        }, executorThread = executorThread.io) {
            remoteDataSource.fetchPopularMovies()
        }
    }

    override suspend fun fetchTopRatedMovies(): Flow<Resource<List<TopRatedMovie>>> {
        return safeApiCall(
            mapFromModel = { response ->
                topRatedMoviesMapper.mapFromModelList(response.topRatedMovies)
            }
        ) { remoteDataSource.fetchTopRatedMovies() }
    }

    override suspend fun fetchUpcomingMovies(): Flow<Resource<List<UpcomingMovie>>> {
        return safeApiCall<UpcomingMoviesResponseDTO, List<UpcomingMovie>>(
            mapFromModel = { response ->
                upcomingMovieMapper.mapFromModelList(response.upcomingMovies)
            }, executorThread = executorThread.io
        ) {
            remoteDataSource.fetchUpcomingMovies()
        }
    }
}