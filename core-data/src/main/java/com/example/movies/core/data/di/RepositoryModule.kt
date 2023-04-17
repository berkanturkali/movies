package com.example.movies.core.data.di

import com.example.movies.core.data.repository.nowplaying.abstraction.NowPlayingRepository
import com.example.movies.core.data.repository.nowplaying.implementation.NowPlayingRepositoryImpl
import com.example.movies.core.data.repository.popular.abstraction.PopularRepository
import com.example.movies.core.data.repository.popular.implementation.PopularRepositoryImpl
import com.example.movies.core.data.repository.search.abstraction.SearchRepository
import com.example.movies.core.data.repository.search.implementation.SearchRepositoryImpl
import com.example.movies.core.data.repository.top_rated.abstraction.TopRatedMoviesRepository
import com.example.movies.core.data.repository.top_rated.implementation.TopRatedMoviesRepositoryImpl
import com.example.movies.core.data.repository.trending.abstraction.TrendingRepository
import com.example.movies.core.data.repository.trending.implementation.TrendingRepositoryImpl
import com.example.movies.core.data.repository.upcoming.abstraction.UpcomingRepository
import com.example.movies.core.data.repository.upcoming.implementation.UpcomingRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@[Module InstallIn(SingletonComponent::class)]
interface RepositoryModule {

    @get:Binds
    val TrendingRepositoryImpl.trendingRepo: TrendingRepository


    @get:Binds
    val NowPlayingRepositoryImpl.nowPlayingRepo: NowPlayingRepository

    @get:Binds
    val UpcomingRepositoryImpl.upcomingRepo: UpcomingRepository

    @get:Binds
    val PopularRepositoryImpl.popularRepo: PopularRepository

    @get:Binds
    val TopRatedMoviesRepositoryImpl.topRateRepo: TopRatedMoviesRepository

    @get:Binds
    val SearchRepositoryImpl.searchRepo: SearchRepository
}