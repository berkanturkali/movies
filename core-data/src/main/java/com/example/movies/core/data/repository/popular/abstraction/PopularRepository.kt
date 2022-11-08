package com.example.movies.core.data.repository.popular.abstraction

import com.example.movies.core.common.Resource
import com.example.movies.core.model.home.PopularMovie
import kotlinx.coroutines.flow.Flow

interface PopularRepository {

    suspend fun fetchPopularMovies(): Flow<Resource<List<PopularMovie>>>
}