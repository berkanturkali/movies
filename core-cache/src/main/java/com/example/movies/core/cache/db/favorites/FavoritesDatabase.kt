package com.example.movies.core.cache.db.favorites

import androidx.room.Database
import com.example.movies.core.cache.BuildConfig
import com.example.movies.core.cache.dao.FavoritesDao
import com.example.movies.core.cache.db.base.BaseDatabase
import com.example.movies.core.cache.model.favorites.MovieEntity

@Database(
    entities = [MovieEntity::class],
    version = BuildConfig.favoritesDatabaseVersion,
    exportSchema = false
)
abstract class FavoritesDatabase : BaseDatabase() {

    abstract val favoritesDao: FavoritesDao
}