package com.example.movies.core.cache.datasource.abstraction.favorites

import com.example.movies.core.cache.model.favorites.MovieEntity
import kotlinx.coroutines.flow.Flow

interface FavoritesCacheDataSource {

    suspend fun upsert(movie: MovieEntity): Long

    fun favorites(): Flow<List<MovieEntity>>

    suspend fun delete(movie: MovieEntity)

    suspend fun clear()
}