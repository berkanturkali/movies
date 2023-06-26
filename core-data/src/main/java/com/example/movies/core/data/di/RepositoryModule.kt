package com.example.movies.core.data.di

import com.example.movies.core.data.repository.movielist.abstraction.MovieListRepository
import com.example.movies.core.data.repository.movielist.implementation.MovieListRepositoryImpl
import com.example.movies.core.data.repository.search.abstraction.SearchRepository
import com.example.movies.core.data.repository.search.implementation.SearchRepositoryImpl
import com.example.movies.core.data.repository.trending.abstraction.TrendingRepository
import com.example.movies.core.data.repository.trending.implementation.TrendingRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@[Module InstallIn(SingletonComponent::class)]
interface RepositoryModule {

    @get:Binds
    val TrendingRepositoryImpl.trendingRepo: TrendingRepository

    @get:Binds
    val MovieListRepositoryImpl.movieListRepository: MovieListRepository

    @get:Binds
    val SearchRepositoryImpl.searchRepo: SearchRepository
}