package com.example.movies.core.data.repository.top_rated.abstraction

import com.example.movies.core.common.Resource
import com.example.movies.core.model.home.TopRatedMovie
import kotlinx.coroutines.flow.Flow

interface TopRatedMoviesRepository {

    suspend fun fetchTopRatedMovies(): Flow<Resource<List<TopRatedMovie>>>
}