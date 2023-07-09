package com.example.movies.core.cache.di

import com.example.movies.core.cache.dao.FavoritesDao
import com.example.movies.core.cache.dao.RecentSearchesDao
import com.example.movies.core.cache.db.favorites.FavoritesDatabase
import com.example.movies.core.cache.db.recentsearches.RecentSearchesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object DaoModule {

    @[Provides Singleton]
    fun provideRecentSearchesDao(recentSearchesDatabase: RecentSearchesDatabase): RecentSearchesDao {
        return recentSearchesDatabase.recentSearchesDao
    }

    @[Provides Singleton]
    fun provideFavoritesDao(favoritesDatabase: FavoritesDatabase): FavoritesDao {
        return favoritesDatabase.favoritesDao
    }
}