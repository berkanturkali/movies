package com.example.movies.feature.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.core.common.executor.abstraction.ExecutorThread
import com.example.movies.feature.home.state.NowPlayingMoviesState
import com.example.movies.feature.home.state.TrendingMoviesState
import com.example.movies.feature.home.usecases.HomeScreenUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val homeScreenUseCases: HomeScreenUseCases,
    private val executorThread: ExecutorThread
) : ViewModel() {

    private val _topTrendingMoviesState =
        MutableStateFlow<TrendingMoviesState>(TrendingMoviesState.Loading)

    val topTrendingMoviesState: StateFlow<TrendingMoviesState> get() = _topTrendingMoviesState

    private val _nowPlayingMoviesState =
        MutableStateFlow<NowPlayingMoviesState>(NowPlayingMoviesState.Loading)

    val nowPlayingMoviesState: StateFlow<NowPlayingMoviesState> get() = _nowPlayingMoviesState

    init {
        fetchTopTrendingMovies()
        fetchNowPlayingMovies()
    }

    fun fetchTopTrendingMovies() {
        viewModelScope.launch(executorThread.main) {
            homeScreenUseCases.fetchTopTrendingMovies().collectLatest { state ->
                _topTrendingMoviesState.update { state }
            }
        }
    }

    fun fetchNowPlayingMovies() {
        viewModelScope.launch(executorThread.main) {
            homeScreenUseCases.fetchNowPlayingMovies().collectLatest { state ->
                _nowPlayingMoviesState.update { state }
            }
        }
    }

}