package com.example.movies.core.data.di

import com.example.movies.core.data.repository.favorites.abstraction.FavoritesRepository
import com.example.movies.core.data.repository.favorites.implementation.FavoritesRepositoryImpl
import com.example.movies.core.data.repository.movielist.abstraction.MovieListRepository
import com.example.movies.core.data.repository.movielist.implementation.MovieListRepositoryImpl
import com.example.movies.core.data.repository.movies.abstraction.MoviesRepository
import com.example.movies.core.data.repository.movies.implementation.MoviesRepositoryImpl
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

    @get:Binds
    val MoviesRepositoryImpl.moviesRepository: MoviesRepository

    @get:Binds
    val FavoritesRepositoryImpl.favoritesRepository: FavoritesRepository
}