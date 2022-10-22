package com.example.movies.feature.home.usecases

import com.example.movies.core.common.Resource
import com.example.movies.core.data.repository.trending.abstraction.TrendingRepository
import com.example.movies.feature.home.state.HighlightedMovieState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchTopTrendingMovieUseCase @Inject constructor(
    private val trendingRepo: TrendingRepository
) {

    suspend operator fun invoke(): Flow<HighlightedMovieState> {
        return flow {
            trendingRepo.fetchTopTrendingMovie()
                .collectLatest { resource ->
                    when (resource) {
                        is Resource.Error -> emit(HighlightedMovieState.Error(resource.error!!))
                        is Resource.Loading -> emit(HighlightedMovieState.Loading)
                        is Resource.Success -> emit(HighlightedMovieState.DataLoaded(resource.data!!))
                    }
                }
        }
    }
}