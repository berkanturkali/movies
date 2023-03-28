package com.example.movies.core.network.factory.retrofit

import com.example.movies.core.network.interceptor.ApiKeyInterceptor
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Factory class that responsible from the creation of [Retrofit] object
 */
class RetrofitFactory @Inject constructor(private val moshi: Moshi) {

    fun createRetrofit(
        url: String,
        isDebug: Boolean,
        apiKeyInterceptor: ApiKeyInterceptor
    ): Retrofit {
        val client: OkHttpClient = makeOkHttpClient(
            httpLoggingInterceptor = makeLoggingInterceptor(isDebug),
            apiKeyInterceptor = apiKeyInterceptor
        )
        return Retrofit
            .Builder()
            .baseUrl(url)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }


    private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = if (isDebug) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return interceptor
    }

    private fun makeOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        apiKeyInterceptor: ApiKeyInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(apiKeyInterceptor)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
    }
}