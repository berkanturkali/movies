package com.example.movies.core.data.repository.nowplaying.implementation

import com.example.movies.core.common.Resource
import com.example.movies.core.common.executor.abstraction.ExecutorThread
import com.example.movies.core.data.repository.nowplaying.abstraction.NowPlayingRepository
import com.example.movies.core.data.utils.safeApiCall
import com.example.movies.core.model.home.NowPlayingMovie
import com.example.movies.core.network.datasource.abstraction.nowplaying.NowPlayingRemoteDataSource
import com.example.movies.core.network.mapper.nowplaying.NowPlayingMoviesResponseMapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NowPlayingRepositoryImpl @Inject constructor(
    private val nowPlayingMoviesResponseMapper: NowPlayingMoviesResponseMapper,
    private val nowPlayingRemoteDataSource: NowPlayingRemoteDataSource,
    private val executorThread: ExecutorThread
) : NowPlayingRepository {
    override suspend fun fetchNowPlayingMovies(): Flow<Resource<List<NowPlayingMovie>>> {
        return safeApiCall(
            mapFromModel = { model ->
                nowPlayingMoviesResponseMapper.mapFromModelList(model.results)
            },
            executorThread = executorThread.io,
        ) {
            nowPlayingRemoteDataSource.fetchNowPlayingMovies()
        }
    }
}