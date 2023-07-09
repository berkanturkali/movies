package com.example.movies.core.cache.dao

import androidx.room.*
import com.example.movies.core.cache.model.favorites.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(movie: MovieEntity): Long

    @Query("SELECT * FROM favorites")
    fun getFavorites(): Flow<List<MovieEntity>>

    @Delete
    suspend fun delete(movie: MovieEntity)

    @Query("DELETE FROM favorites")
    suspend fun clear()
}