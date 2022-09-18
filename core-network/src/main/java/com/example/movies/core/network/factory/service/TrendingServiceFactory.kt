package com.example.movies.core.network.factory.service

import com.example.movies.core.network.service.trending.TrendingService
import retrofit2.Retrofit

object TrendingServiceFactory : RetrofitServiceFactory<TrendingService> {
    override fun createService(retrofit: Retrofit): TrendingService {
        return retrofit.create(TrendingService::class.java)
    }
}