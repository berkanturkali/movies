package com.example.movies.core.data.repository.trending.implementation

import com.example.movies.core.common.Resource
import com.example.movies.core.common.executor.abstraction.ExecutorThread
import com.example.movies.core.data.repository.trending.abstraction.TrendingRepository
import com.example.movies.core.data.repository.utils.safeApiCall
import com.example.movies.core.model.home.TrendingMovie
import com.example.movies.core.network.datasource.abstraction.trending.TrendingRemoteDataSource
import com.example.movies.core.network.mapper.trending.TopTrendingMoviesResponseMapper
import com.example.movies.core.network.model.trending.TrendingResponseDTO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TrendingRepositoryImpl @Inject constructor(
    private val trendingRemoteDataSource: TrendingRemoteDataSource,
    private val trendingMoviesResponseMapper: TopTrendingMoviesResponseMapper,
    private val executorThread: ExecutorThread,
) : TrendingRepository {
    override suspend fun fetchTopTrendingMovie(): Flow<Resource<TrendingMovie>> {
        return safeApiCall<TrendingResponseDTO, TrendingMovie>(
            mapFromModel = { response ->
                trendingMoviesResponseMapper.mapFromModel(response.trendingMovies[0])
            },
            executorThread = executorThread.io
        ) {
            trendingRemoteDataSource.fetchTopTrendingMovies()
        }
    }
}