package com.example.movies.feature.home.usecases

import com.example.movies.core.common.Resource
import com.example.movies.core.data.repository.nowplaying.abstraction.NowPlayingRepository
import com.example.movies.feature.home.state.NowPlayingMoviesState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchNowPlayingMoviesUseCase @Inject constructor(
    private val repo: NowPlayingRepository
) {

    suspend operator fun invoke(): Flow<NowPlayingMoviesState> {
        return flow {
            repo.fetchNowPlayingMovies().collectLatest { resource ->
                when (resource) {
                    is Resource.Error -> emit(NowPlayingMoviesState.Error(resource.error!!))
                    is Resource.Loading -> emit(NowPlayingMoviesState.Loading)
                    is Resource.Success -> emit(NowPlayingMoviesState.DataLoaded(resource.data!!))
                }
            }
        }
    }
}