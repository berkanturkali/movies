package com.example.movies.core.cache.db.recentsearches

import androidx.room.Database
import com.example.movies.core.cache.BuildConfig
import com.example.movies.core.cache.dao.RecentSearchesDao
import com.example.movies.core.cache.db.base.BaseDatabase
import com.example.movies.core.cache.model.RecentSearchEntity

@Database(
    entities = [RecentSearchEntity::class],
    version = BuildConfig.recentSearchesDatabaseVersion,
    exportSchema = false
)
abstract class RecentSearchesDatabase : BaseDatabase() {

    abstract val recentSearchesDao: RecentSearchesDao
}