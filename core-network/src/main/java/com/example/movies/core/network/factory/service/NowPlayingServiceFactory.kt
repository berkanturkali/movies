package com.example.movies.core.network.factory.service

import com.example.movies.core.network.service.nowplaying.NowPlayingService
import retrofit2.Retrofit

object NowPlayingServiceFactory : RetrofitServiceFactory<NowPlayingService> {
    override fun createService(retrofit: Retrofit): NowPlayingService {
        return retrofit.create(NowPlayingService::class.java)
    }
}