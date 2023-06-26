package com.example.movies.core.data.repository.movielist.abstraction

import com.example.movies.core.common.Resource
import com.example.movies.core.model.home.NowPlayingMovie
import com.example.movies.core.model.home.PopularMovie
import com.example.movies.core.model.home.TopRatedMovie
import com.example.movies.core.model.home.UpcomingMovie
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {

    suspend fun fetchNowPlayingMovies(): Flow<Resource<List<NowPlayingMovie>>>

    suspend fun fetchPopularMovies(): Flow<Resource<List<PopularMovie>>>

    suspend fun fetchTopRatedMovies(): Flow<Resource<List<TopRatedMovie>>>

    suspend fun fetchUpcomingMovies(): Flow<Resource<List<UpcomingMovie>>>
}