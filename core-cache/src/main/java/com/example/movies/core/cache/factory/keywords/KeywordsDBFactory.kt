package com.example.movies.core.cache.factory.keywords

import android.content.Context
import com.example.movies.core.cache.BuildConfig
import com.example.movies.core.cache.db.keywords.KeywordsDatabase
import com.example.movies.core.cache.factory.AbstractDBFactory
import com.example.movies.core.cache.factory.DBFactory

object KeywordsDBFactory : AbstractDBFactory<KeywordsDatabase>() {
    override fun createDatabase(context: Context): KeywordsDatabase {
        return DBFactory.createDatabase(context, BuildConfig.keywordsDatabaseName)
    }
}