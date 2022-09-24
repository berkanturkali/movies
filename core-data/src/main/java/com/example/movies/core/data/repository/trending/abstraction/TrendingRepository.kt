package com.example.movies.core.data.repository.trending.abstraction

interface TrendingRepository {

    suspend fun fetchTopTrendingMovie()
}