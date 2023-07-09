package com.example.movies.core.cache.di

import com.example.movies.core.cache.datasource.abstraction.favorites.FavoritesCacheDataSource
import com.example.movies.core.cache.datasource.abstraction.recentsearches.RecentSearchesCacheDataSource
import com.example.movies.core.cache.datasource.implementation.favorites.FavoritesCacheDataSourceImpl
import com.example.movies.core.cache.datasource.implementation.recentsearches.RecentSearchesCacheDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@[Module InstallIn(SingletonComponent::class)]
interface CacheDataSourceModule {

    @get:Binds
    val RecentSearchesCacheDataSourceImpl.recentSearchesDataSource: RecentSearchesCacheDataSource

    @get:Binds
    val FavoritesCacheDataSourceImpl.favoritesCacheDataSource: FavoritesCacheDataSource

}