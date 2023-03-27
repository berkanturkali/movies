package com.example.movies.core.network.factory.service

import com.example.movies.core.network.service.search.SearchService
import retrofit2.Retrofit

object SearchServiceFactory : RetrofitServiceFactory<SearchService> {
    override fun createService(retrofit: Retrofit): SearchService {
        return retrofit.create(SearchService::class.java)
    }
}