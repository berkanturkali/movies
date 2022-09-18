package com.example.movies.core.network.factory.service

import com.example.movies.core.network.service.base.BaseService
import retrofit2.Retrofit

/**
 * Abstract factory class that responsible from the creation of Api services.
 *
 * [T] is service type that will be created and returned.
 */
interface RetrofitServiceFactory<T : BaseService> {

    fun createService(retrofit: Retrofit): T
}