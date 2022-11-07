package com.example.movies.feature.home.usecases

import com.example.movies.core.common.Resource
import com.example.movies.core.data.repository.upcoming.abstraction.UpcomingRepository
import com.example.movies.feature.home.state.UpcomingMoviesState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchUpcomingMoviesUseCase @Inject constructor(
    private val repo: UpcomingRepository
) {

    suspend operator fun invoke(): Flow<UpcomingMoviesState> {
        return flow {
            repo.fetchUpcomingMovies().collectLatest { resource ->
                when (resource) {
                    is Resource.Error -> emit(UpcomingMoviesState.Error(resource.error!!))
                    is Resource.Loading -> emit(UpcomingMoviesState.Loading)
                    is Resource.Success -> emit(UpcomingMoviesState.DataLoaded(resource.data!!))
                }
            }
        }
    }
}