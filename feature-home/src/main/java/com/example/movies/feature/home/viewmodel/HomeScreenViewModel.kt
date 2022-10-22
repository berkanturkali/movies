package com.example.movies.feature.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.core.common.executor.abstraction.ExecutorThread
import com.example.movies.feature.home.state.HighlightedMovieState
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

    private val _highlightedMovieState =
        MutableStateFlow<HighlightedMovieState>(HighlightedMovieState.Loading)

    val highlightedMovieState: StateFlow<HighlightedMovieState> get() = _highlightedMovieState

    init {
        fetchTopTrendingMovie()
    }

    fun fetchTopTrendingMovie() {
        viewModelScope.launch(executorThread.main) {
            homeScreenUseCases.fetchTopTrendingMovie().collectLatest { state ->
                _highlightedMovieState.update { state }
            }
        }
    }
}