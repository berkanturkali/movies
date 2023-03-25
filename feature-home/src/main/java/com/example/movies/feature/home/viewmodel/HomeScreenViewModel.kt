package com.example.movies.feature.home.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.core.common.executor.abstraction.ExecutorThread
import com.example.movies.core.model.utils.Quintuple
import com.example.movies.feature.home.state.*
import com.example.movies.feature.home.usecases.HomeScreenUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
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

    private val _upcomingMoviesState =
        MutableStateFlow<UpcomingMoviesState>(UpcomingMoviesState.Loading)

    val upcomingMoviesState: StateFlow<UpcomingMoviesState> get() = _upcomingMoviesState

    private val _popularMoviesState =
        MutableStateFlow<PopularMoviesState>(PopularMoviesState.Loading)

    val popularMoviesState: StateFlow<PopularMoviesState> get() = _popularMoviesState

    private val _topRatedMoviesState =
        MutableStateFlow<TopRatedMoviesState>(TopRatedMoviesState.Loading)

    val topRatedMoviesState: StateFlow<TopRatedMoviesState> get() = _topRatedMoviesState

    val loading =
        combine(
            _topTrendingMoviesState,
            _nowPlayingMoviesState,
            _upcomingMoviesState,
            _popularMoviesState,
            _topRatedMoviesState,
            ::Quintuple
        ).mapLatest {
            it.first == TrendingMoviesState.Loading ||
                    it.second == NowPlayingMoviesState.Loading ||
                    it.third == UpcomingMoviesState.Loading ||
                    it.fourth == PopularMoviesState.Loading ||
                    it.fifth == TopRatedMoviesState.Loading
        }

    val error =
        combine(
            _topTrendingMoviesState,
            _nowPlayingMoviesState,
            _upcomingMoviesState,
            _popularMoviesState,
            _topRatedMoviesState,
            ::Quintuple
        ).mapLatest { quinTuple ->
            if(quinTuple.first is TrendingMoviesState.Error &&
                    quinTuple.second is NowPlayingMoviesState.Error &&
                    quinTuple.third is UpcomingMoviesState.Error &&
                    quinTuple.fourth is PopularMoviesState.Error &&
                    quinTuple.fifth is TopRatedMoviesState.Error){
                (quinTuple.first as TrendingMoviesState.Error).errorMessage
            }else{
                null
            }
        }


    init {
        fetchAllMovies()
    }

    fun fetchTopTrendingMovies() {
        viewModelScope.launch(executorThread.main) {
            homeScreenUseCases.fetchTopTrendingMovies()
                .collect { state ->
                    _topTrendingMoviesState.update { state }
                }
        }
    }

    fun fetchNowPlayingMovies() {
        viewModelScope.launch(executorThread.main) {
            homeScreenUseCases.fetchNowPlayingMovies()
                .collect { state ->
                    _nowPlayingMoviesState.update { state }
                }
        }
    }

    fun fetchUpcomingMovies() {
        viewModelScope.launch(executorThread.main) {
            homeScreenUseCases.fetchUpcomingMovies()
                .collect { state ->
                    _upcomingMoviesState.update { state }
                }
        }
    }

    fun fetchPopularMovies() {
        viewModelScope.launch(executorThread.main) {
            homeScreenUseCases.fetchPopularMovies()
                .collect { state ->
                    _popularMoviesState.update { state }
                }
        }
    }

    fun fetchTopRatedMovies() {
        viewModelScope.launch(executorThread.main) {
            homeScreenUseCases.fetchTopRatedMoviesUseCase()
                .collect { state ->
                    _topRatedMoviesState.update {
                        state
                    }
                }
        }
    }

    fun fetchAllMovies() {
        fetchTopTrendingMovies()
        fetchNowPlayingMovies()
        fetchUpcomingMovies()
        fetchPopularMovies()
        fetchTopRatedMovies()
    }
}