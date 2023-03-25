package com.example.movies.core.network.di

import com.example.movies.core.network.datasource.abstraction.nowplaying.NowPlayingRemoteDataSource
import com.example.movies.core.network.datasource.abstraction.popular.PopularRemoteDataSource
import com.example.movies.core.network.datasource.abstraction.top_rated.TopRatedMoviesRemoteDataSource
import com.example.movies.core.network.datasource.abstraction.trending.TrendingRemoteDataSource
import com.example.movies.core.network.datasource.abstraction.upcoming.UpcomingRemoteDataSource
import com.example.movies.core.network.datasource.implementation.nowplaying.NowPlayingRemoteDataSourceImpl
import com.example.movies.core.network.datasource.implementation.popular.PopularRemoteDataSourceImpl
import com.example.movies.core.network.datasource.implementation.top_rated.TopRatedMoviesRemoteDataSourceImpl
import com.example.movies.core.network.datasource.implementation.trending.TrendingRemoteDataSourceImpl
import com.example.movies.core.network.datasource.implementation.upcoming.UpcomingRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@[Module InstallIn(SingletonComponent::class)]
interface RemoteDataSourceModule {

    @get:Binds
    val TrendingRemoteDataSourceImpl.trendingRemoteDataSource: TrendingRemoteDataSource

    @get:Binds
    val NowPlayingRemoteDataSourceImpl.nowPlayingRemoteDataSource: NowPlayingRemoteDataSource

    @get:Binds
    val UpcomingRemoteDataSourceImpl.upcomingRemoteDataSource: UpcomingRemoteDataSource

    @get:Binds
    val PopularRemoteDataSourceImpl.popularRemoteDataSource: PopularRemoteDataSource

    @get:Binds
    val TopRatedMoviesRemoteDataSourceImpl.topRatedMoviesRemoteDataSource: TopRatedMoviesRemoteDataSource
}