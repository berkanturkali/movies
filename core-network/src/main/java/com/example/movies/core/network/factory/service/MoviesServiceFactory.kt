package com.example.movies.core.network.factory.service

import com.example.movies.core.network.service.movies.MoviesService
import retrofit2.Retrofit

object MoviesServiceFactory : RetrofitServiceFactory<MoviesService> {
    override fun createService(retrofit: Retrofit): MoviesService {
        return retrofit.create(MoviesService::class.java)
    }
}