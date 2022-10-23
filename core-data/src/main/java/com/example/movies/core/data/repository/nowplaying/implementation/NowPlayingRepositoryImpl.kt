package com.example.movies.core.data.repository.nowplaying.implementation

import com.example.movies.core.common.Resource
import com.example.movies.core.data.repository.nowplaying.abstraction.NowPlayingRepository
import com.example.movies.core.model.home.NowPlayingMovie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NowPlayingRepositoryImpl @Inject constructor() : NowPlayingRepository {
    override suspend fun fetchNowPlayingMovies(): Flow<Resource<NowPlayingMovie>> {
        TODO("Not yet implemented")
    }
}