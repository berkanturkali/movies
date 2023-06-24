package com.example.movies.feature.home.usecases

import com.example.movies.core.common.UiText
import com.example.movies.core.data.R
import com.example.movies.core.data.repository.movie_list.abstraction.MovieListRepository
import com.example.movies.feature.home.state.NowPlayingMoviesState
import com.example.movies.feature.home.util.flatMapMergeThenEmit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchNowPlayingMoviesUseCase @Inject constructor(
    private val repo: MovieListRepository
) {

    suspend operator fun invoke(): Flow<NowPlayingMoviesState> {
        val flow = repo.fetchNowPlayingMovies()
            .flatMapMergeThenEmit(
                onSuccessEmission = {
                    NowPlayingMoviesState.DataLoaded(it.data!!)
                },
                onLoadingEmission = {
                    NowPlayingMoviesState.Loading
                },
                onErrorEmission = {
                    NowPlayingMoviesState.Error(
                        it.error ?: UiText.StringResource(
                            R.string.something_went_wrong_error_message
                        )
                    )
                }
            )
        return flow
    }
}