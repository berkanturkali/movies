package com.example.movies.core.data.repository.nowplaying.abstraction

import com.example.movies.core.common.Resource
import com.example.movies.core.model.home.NowPlayingMovie
import kotlinx.coroutines.flow.Flow

interface NowPlayingRepository {

    suspend fun fetchNowPlayingMovies(): Flow<Resource<List<NowPlayingMovie>>>
}