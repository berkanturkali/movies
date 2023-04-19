package com.example.movies.core.cache.db.keywords

import androidx.room.Database
import com.example.movies.core.cache.BuildConfig
import com.example.movies.core.cache.dao.KeywordsDao
import com.example.movies.core.cache.dao.RemoteKeyDao
import com.example.movies.core.cache.db.base.BaseDatabase
import com.example.movies.core.cache.model.KeywordEntity
import com.example.movies.core.cache.model.RemoteKey

@Database(
    entities = [KeywordEntity::class, RemoteKey::class],
    version = BuildConfig.keywordsDatabaseVersion,
    exportSchema = false
)
abstract class KeywordsDatabase : BaseDatabase() {

    abstract val keywordsDao: KeywordsDao

    abstract val remoteKeyDao: RemoteKeyDao
}