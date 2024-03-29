package com.example.movies.feature.home.usecases

import javax.inject.Inject

data class HomeScreenUseCases @Inject constructor(
    val fetchTopTrendingMovies: FetchTopTrendingMoviesUseCase,
    val fetchNowPlayingMovies: FetchNowPlayingMoviesUseCase,
    val fetchUpcomingMovies: FetchUpcomingMoviesUseCase,
    val fetchPopularMovies: FetchPopularMoviesUseCase,
    val fetchTopRatedMoviesUseCase: FetchTopRatedMoviesUseCase,
)