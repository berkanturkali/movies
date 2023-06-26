package com.example.movies.core.cache.di

import android.content.Context
import com.example.movies.core.cache.dao.RecentSearchesDao
import com.example.movies.core.cache.db.recentsearches.RecentSearchesDatabase
import com.example.movies.core.cache.factory.recentsearches.RecentSearchesDBFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
class CacheModule {
    @[Provides Singleton]
    fun provideRecentSearchesDatabase(@ApplicationContext context: Context): RecentSearchesDatabase {
        return RecentSearchesDBFactory.createDatabase(context)
    }

    @[Provides Singleton]
    fun provideRecentSearchesDao(recentSearchesDatabase: RecentSearchesDatabase): RecentSearchesDao {
        return recentSearchesDatabase.recentSearchesDao
    }
}