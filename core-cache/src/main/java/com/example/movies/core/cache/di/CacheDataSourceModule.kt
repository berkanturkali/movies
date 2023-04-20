package com.example.movies.core.cache.di

import com.example.movies.core.cache.datasource.abstraction.RecentSearchesCacheDataSource
import com.example.movies.core.cache.datasource.implementation.RecentSearchesCacheDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@[Module InstallIn(SingletonComponent::class)]
interface CacheDataSourceModule {

    @get:Binds
    val RecentSearchesCacheDataSourceImpl.recentSearchesDataSource: RecentSearchesCacheDataSource

}