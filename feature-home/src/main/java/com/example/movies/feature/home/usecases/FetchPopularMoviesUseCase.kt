package com.example.movies.feature.home.usecases

import com.example.movies.core.common.Resource
import com.example.movies.core.data.repository.popular.abstraction.PopularRepository
import com.example.movies.feature.home.state.PopularMoviesState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchPopularMoviesUseCase @Inject constructor(
    private val repo: PopularRepository
) {
    suspend operator fun invoke(): Flow<PopularMoviesState> {
        return flow {
            repo.fetchPopularMovies().collectLatest { resource ->
                when (resource) {
                    is Resource.Error -> {
                        emit(PopularMoviesState.Error(resource.error!!))
                    }
                    is Resource.Loading -> emit(PopularMoviesState.Loading)
                    is Resource.Success -> {
                        emit(PopularMoviesState.DataLoaded(resource.data!!))
                    }
                }
            }
        }
    }
}