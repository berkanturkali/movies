package com.example.movies.feature.home.usecases

import com.example.movies.core.common.UiText
import com.example.movies.core.data.repository.trending.abstraction.TrendingRepository
import com.example.movies.feature.home.state.TrendingMoviesState
import com.example.movies.feature.home.util.flatMapMergeThenEmit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchTopTrendingMoviesUseCase @Inject constructor(
    private val trendingRepo: TrendingRepository
) {
    suspend operator fun invoke(): Flow<TrendingMoviesState> {
        val flow = trendingRepo.fetchTopTrendingMovies()
            .flatMapMergeThenEmit(
                onSuccessEmission = {
                    TrendingMoviesState.DataLoaded(it.data!!)
                },
                onLoadingEmission = {
                    TrendingMoviesState.Loading
                },
                onErrorEmission = {
                    TrendingMoviesState.Error(
                        it.error ?: UiText.StringResource(
                            com.example.movies.core.data.R.string.something_went_wrong_error_message
                        )
                    )
                }
            )
        return flow
    }
}