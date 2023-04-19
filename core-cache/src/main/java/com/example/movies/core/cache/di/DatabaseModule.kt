package com.example.movies.core.cache.di

import android.content.Context
import com.example.movies.core.cache.dao.KeywordsDao
import com.example.movies.core.cache.dao.RecentSearchesDao
import com.example.movies.core.cache.dao.RemoteKeyDao
import com.example.movies.core.cache.db.keywords.KeywordsDatabase
import com.example.movies.core.cache.db.recentsearches.RecentSearchesDatabase
import com.example.movies.core.cache.factory.keywords.KeywordsDBFactory
import com.example.movies.core.cache.factory.recent_searches.RecentSearchesDBFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
class CacheModule {

    @[Provides Singleton]
    fun provideKeywordsDatabase(@ApplicationContext context: Context): KeywordsDatabase {
        return KeywordsDBFactory.createDatabase(context)
    }

    @[Provides Singleton]
    fun provideRecentSearchesDatabase(@ApplicationContext context: Context): RecentSearchesDatabase {
        return RecentSearchesDBFactory.createDatabase(context)
    }

    @[Provides Singleton]
    fun provideKeywordsDao(keywordsDatabase: KeywordsDatabase): KeywordsDao {
        return keywordsDatabase.keywordsDao
    }

    @[Provides Singleton]
    fun provideRemoteKeyDao(keywordsDatabase: KeywordsDatabase): RemoteKeyDao {
        return keywordsDatabase.remoteKeyDao
    }

    @[Provides Singleton]
    fun provideRecentSearchesDao(recentSearchesDatabase: RecentSearchesDatabase): RecentSearchesDao {
        return recentSearchesDatabase.recentSearchesDao
    }
}