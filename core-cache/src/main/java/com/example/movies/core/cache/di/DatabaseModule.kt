package com.example.movies.core.cache.di

import android.content.Context
import com.example.movies.core.cache.dao.KeywordsDao
import com.example.movies.core.cache.dao.RemoteKeyDao
import com.example.movies.core.cache.db.keywords.KeywordsDatabase
import com.example.movies.core.cache.factory.keywords.KeywordsDBFactory
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
    fun provideKeywordsDao(keywordsDatabase: KeywordsDatabase): KeywordsDao {
        return keywordsDatabase.keywordsDao
    }

    @[Provides Singleton]
    fun provideRemoteKeyDao(keywordsDatabase: KeywordsDatabase): RemoteKeyDao {
        return keywordsDatabase.remoteKeyDao
    }
}