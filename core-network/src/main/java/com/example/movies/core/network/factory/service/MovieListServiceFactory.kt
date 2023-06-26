package com.example.movies.core.network.factory.service

import com.example.movies.core.network.service.movielist.MovieListService
import retrofit2.Retrofit

object MovieListServiceFactory : RetrofitServiceFactory<MovieListService> {
    override fun createService(retrofit: Retrofit): MovieListService {
        return retrofit.create(MovieListService::class.java)
    }
}