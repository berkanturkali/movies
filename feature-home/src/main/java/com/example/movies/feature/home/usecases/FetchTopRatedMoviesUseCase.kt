package com.example.movies.feature.home.usecases

import com.example.movies.core.common.UiText
import com.example.movies.core.data.R
import com.example.movies.core.data.repository.movielist.abstraction.MovieListRepository
import com.example.movies.feature.home.state.TopRatedMoviesState
import com.example.movies.feature.home.util.flatMapMergeThenEmit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchTopRatedMoviesUseCase @Inject constructor(
    private val topRatedMoviesRepo: MovieListRepository
) {
    suspend operator fun invoke(): Flow<TopRatedMoviesState> {
        val flow = topRatedMoviesRepo.fetchTopRatedMovies()
            .flatMapMergeThenEmit(
                onSuccessEmission = {
                    TopRatedMoviesState.TopRatedMovies(it.data ?: emptyList())
                },
                onLoadingEmission = {
                    TopRatedMoviesState.Loading
                },
                onErrorEmission = {
                    TopRatedMoviesState.Error(
                        it.error ?: UiText.StringResource(
                            R.string.something_went_wrong_error_message
                        )
                    )
                }
            )
        return flow
    }
}