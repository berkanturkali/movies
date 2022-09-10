package com.example.movies.core.network.di

import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.factory.retrofit.RetrofitFactory
import com.example.movies.core.network.factory.service.TrendingServiceFactory
import com.example.movies.core.network.trending.service.TrendingService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Hilt module that provides [Retrofit] instance and Api services.
 */
@[Module InstallIn(SingletonComponent::class)]
object RetrofitModule {

    @[Provides Singleton]
    fun provideRetrofit(
        retrofitFactory: RetrofitFactory,
    ): Retrofit {
        return retrofitFactory.createRetrofit(
            url = BuildConfig.BASE_URL,
            isDebug = BuildConfig.DEBUG
        )
    }

    @[Provides Singleton]
    fun provideTrendingFactory(retrofit: Retrofit): TrendingService {
        return TrendingServiceFactory.createService(retrofit)
    }

}