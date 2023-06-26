package com.example.movies.feature.home.usecases

import com.example.movies.core.common.UiText
import com.example.movies.core.data.R
import com.example.movies.core.data.repository.movielist.abstraction.MovieListRepository
import com.example.movies.feature.home.state.PopularMoviesState
import com.example.movies.feature.home.util.flatMapMergeThenEmit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchPopularMoviesUseCase @Inject constructor(
    private val repo: MovieListRepository
) {
    suspend operator fun invoke(): Flow<PopularMoviesState> {
        val flow = repo.fetchPopularMovies()
            .flatMapMergeThenEmit(
                onSuccessEmission = {
                    PopularMoviesState.DataLoaded(it.data!!)
                },
                onLoadingEmission = {
                    PopularMoviesState.Loading
                },
                onErrorEmission = {
                    PopularMoviesState.Error(
                        it.error ?: UiText.StringResource(
                            R.string.something_went_wrong_error_message
                        )
                    )
                }
            )
        return flow
    }
}