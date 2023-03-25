package com.example.movies.core.data.repository.top_rated.implementation

import com.example.movies.core.common.Resource
import com.example.movies.core.data.repository.top_rated.abstraction.TopRatedMoviesRepository
import com.example.movies.core.data.utils.safeApiCall
import com.example.movies.core.model.home.TopRatedMovie
import com.example.movies.core.network.datasource.abstraction.top_rated.TopRatedMoviesRemoteDataSource
import com.example.movies.core.network.mapper.top_rated.TopRatedMovieMapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopRatedMoviesRepositoryImpl @Inject constructor(
    private val remoteDataSource: TopRatedMoviesRemoteDataSource,
    private val topRatedMoviesMapper: TopRatedMovieMapper
) : TopRatedMoviesRepository {
    override suspend fun fetchTopRatedMovies(): Flow<Resource<List<TopRatedMovie>>> {
        return safeApiCall(
            mapFromModel = { response ->
                topRatedMoviesMapper.mapFromModelList(response.topRatedMovies)
            }
        ) { remoteDataSource.fetchTopRatedMovies() }
    }
}