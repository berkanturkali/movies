package com.example.movies.core.network.interceptor

import com.example.movies.core.network.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiKeyInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .url(
                chain.request().url.newBuilder()
                    .addQueryParameter(name = "api_key", value = BuildConfig.API_KEY)
                    .build()
            )
            .build()
        return chain.proceed(request)
    }
}