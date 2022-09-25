package com.example.movies.core.data.repository.trending.abstraction

import com.example.movies.core.common.Resource
import com.example.movies.core.model.home.TrendingMovie
import kotlinx.coroutines.flow.Flow

interface TrendingRepository {

    suspend fun fetchTopTrendingMovie(): Flow<Resource<TrendingMovie>>
}