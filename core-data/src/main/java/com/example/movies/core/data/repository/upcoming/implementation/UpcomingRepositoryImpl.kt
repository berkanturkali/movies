package com.example.movies.core.data.repository.upcoming.implementation

import com.example.movies.core.common.Resource
import com.example.movies.core.common.executor.abstraction.ExecutorThread
import com.example.movies.core.data.repository.upcoming.abstraction.UpcomingRepository
import com.example.movies.core.data.utils.safeApiCall
import com.example.movies.core.model.home.UpcomingMovie
import com.example.movies.core.network.datasource.implementation.upcoming.abstraction.UpcomingRemoteDataSource
import com.example.movies.core.network.mapper.upcoming.UpcomingMovieMapper
import com.example.movies.core.network.model.upcoming.UpcomingMoviesResponseDTO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpcomingRepositoryImpl @Inject constructor(
    private val upcomingMovieMapper: UpcomingMovieMapper,
    private val upcomingDataSource: UpcomingRemoteDataSource,
    private val executorThread: ExecutorThread,
) : UpcomingRepository {
    override suspend fun fetchUpcomingMovies(): Flow<Resource<List<UpcomingMovie>>> {
        return safeApiCall<UpcomingMoviesResponseDTO, List<UpcomingMovie>>(mapFromModel = { response ->
            upcomingMovieMapper.mapFromModelList(response.upcomingMovies)
        }, executorThread = executorThread.io) {
            upcomingDataSource.fetchUpcomingMovies()
        }
    }
}