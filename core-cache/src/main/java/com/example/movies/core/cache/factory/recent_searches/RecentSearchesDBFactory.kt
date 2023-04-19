package com.example.movies.core.cache.factory.recent_searches

import android.content.Context
import com.example.movies.core.cache.BuildConfig
import com.example.movies.core.cache.db.recentsearches.RecentSearchesDatabase
import com.example.movies.core.cache.factory.AbstractDBFactory
import com.example.movies.core.cache.factory.DBFactory

object RecentSearchesDBFactory : AbstractDBFactory<RecentSearchesDatabase>() {
    override fun createDatabase(context: Context): RecentSearchesDatabase {
        return DBFactory.createDatabase(context, BuildConfig.recentSearchesDatabaseName)
    }
}