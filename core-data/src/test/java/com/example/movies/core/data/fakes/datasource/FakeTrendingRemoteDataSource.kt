package com.example.movies.core.data.fakes.datasource

import com.example.movies.core.data.utils.DummyData
import com.example.movies.core.network.datasource.abstraction.trending.TrendingRemoteDataSource
import com.example.movies.core.network.model.trending.TrendingResponseDTO
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

class FakeTrendingRemoteDataSource : TrendingRemoteDataSource, BaseFakeDataSource() {

    override suspend fun fetchTopTrendingMovies(): Response<TrendingResponseDTO> {
        return if (!throwException) {
            if (returnError) {
                Response.error(
                    errorCode,
                    errorResponse
                        .toResponseBody(
                            "application/json".toMediaTypeOrNull()
                        )
                )
            } else {
                if (successButNull) {
                    Response.success(null)
                } else {
                    Response.success(DummyData.trendingResponseDTO)
                }
            }
        } else {
            throw exception
        }
    }
}