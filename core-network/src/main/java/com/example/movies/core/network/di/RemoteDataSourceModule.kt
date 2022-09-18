package com.example.movies.core.network.di

import com.example.movies.core.network.datasource.abstraction.trending.TrendingRemoteDataSource
import com.example.movies.core.network.datasource.implementation.TrendingRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@[Module InstallIn(SingletonComponent::class)]
interface RemoteDataSourceModule {

    @get:Binds
    val TrendingRemoteDataSourceImpl.trendingRemoteDataSource: TrendingRemoteDataSource
}