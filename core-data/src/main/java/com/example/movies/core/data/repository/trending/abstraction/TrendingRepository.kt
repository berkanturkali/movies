package com.example.movies.core.data.repository.trending.abstraction

import com.example.movies.core.model.home.TrendingMovie

interface TrendingRepository {

    suspend fun fetchTopTrendingMovie(): TrendingMovie
}