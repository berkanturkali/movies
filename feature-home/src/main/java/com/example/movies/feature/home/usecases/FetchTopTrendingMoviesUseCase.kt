package com.example.movies.feature.home.usecases

import com.example.movies.core.common.Resource
import com.example.movies.core.data.repository.trending.abstraction.TrendingRepository
import com.example.movies.feature.home.state.TrendingMoviesState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchTopTrendingMoviesUseCase @Inject constructor(
    private val trendingRepo: TrendingRepository
) {

    suspend operator fun invoke(): Flow<TrendingMoviesState> {
        return flow {
            trendingRepo.fetchTopTrendingMovies()
                .collectLatest { resource ->
                    when (resource) {
                        is Resource.Error -> emit(TrendingMoviesState.Error(resource.error!!))
                        is Resource.Loading -> emit(TrendingMoviesState.Loading)
                        is Resource.Success -> emit(TrendingMoviesState.DataLoaded(resource.data!!))
                    }
                }
        }
    }
}