package com.example.movies.core.network.di

import com.example.movies.core.network.datasource.abstraction.movielist.MovieListRemoteDataSource
import com.example.movies.core.network.datasource.abstraction.search.SearchRemoteDataSource
import com.example.movies.core.network.datasource.abstraction.trending.TrendingRemoteDataSource
import com.example.movies.core.network.datasource.implementation.movielist.MovieListRemoteDataSourceImpl
import com.example.movies.core.network.datasource.implementation.search.SearchRemoteDataSourceImpl
import com.example.movies.core.network.datasource.implementation.trending.TrendingRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@[Module InstallIn(SingletonComponent::class)]
interface RemoteDataSourceModule {

    @get:Binds
    val TrendingRemoteDataSourceImpl.trendingRemoteDataSource: TrendingRemoteDataSource

    @get:Binds
    val SearchRemoteDataSourceImpl.searchRemoteDataSource: SearchRemoteDataSource

    @get:Binds
    val MovieListRemoteDataSourceImpl.movieListRemoteDataSource: MovieListRemoteDataSource
}