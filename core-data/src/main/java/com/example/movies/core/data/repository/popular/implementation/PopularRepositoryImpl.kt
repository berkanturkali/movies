package com.example.movies.core.data.repository.popular.implementation

import com.example.movies.core.common.Resource
import com.example.movies.core.common.executor.abstraction.ExecutorThread
import com.example.movies.core.data.repository.popular.abstraction.PopularRepository
import com.example.movies.core.data.utils.safeApiCall
import com.example.movies.core.model.home.PopularMovie
import com.example.movies.core.network.datasource.abstraction.popular.PopularRemoteDataSource
import com.example.movies.core.network.mapper.popular.PopularMovieMapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularRepositoryImpl @Inject constructor(
    private val popularMovieMapper: PopularMovieMapper,
    private val popularRemoteDataSource: PopularRemoteDataSource,
    private val executorThread: ExecutorThread
) : PopularRepository {
    override suspend fun fetchPopularMovies(): Flow<Resource<List<PopularMovie>>> {
        return safeApiCall(mapFromModel = { popularMoviesResponse ->
            popularMovieMapper.mapFromModelList(popularMoviesResponse.popularMovies)
        }, executorThread = executorThread.io) {
            popularRemoteDataSource.fetchPopularMovies()
        }
    }
}