package com.example.movies.core.data.fakes.datasource

import com.example.movies.core.data.utils.DummyData
import com.example.movies.core.network.datasource.abstraction.trending.TrendingRemoteDataSource
import com.example.movies.core.network.model.trending.TrendingResponseDTO
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import java.io.IOException

class FakeTrendingRemoteDataSource : TrendingRemoteDataSource {

    private var returnError: Boolean = false

    private var successButNull: Boolean = false

    private var throwException: Boolean = false

    private var exception: Exception = IOException()

    private var errorCode: Int = 401

    val errorResponse =
        "{\"success\":false,\"status_code\":22,\"status_message\":\"Invalidpage:Pages start at 1 and max at 1000.They are expected to be an integer.\"}"

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

    internal fun setReturnError(returnError: Boolean) {
        this.returnError = returnError
    }

    internal fun setSuccessButNull(successButNull: Boolean) {
        this.successButNull = successButNull
    }

    internal fun setThrowException(throwException: Boolean) {
        this.throwException = throwException
    }

    internal fun setErrorCode(code: Int) {
        errorCode = code
    }

    internal fun setException(exception: Exception) {
        this.exception = exception
    }
}