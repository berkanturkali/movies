package com.example.movies.core.data.utils

import com.example.movies.core.common.Resource
import com.example.movies.core.common.UiText
import com.example.movies.core.data.R
import com.example.movies.core.network.model.error.ErrorResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import timber.log.Timber
import java.io.IOException
import java.lang.reflect.ParameterizedType
import java.util.concurrent.TimeoutException

/**
 * Utility function to fetch and return the response that the MovieDb API sends.
 *
 * @param ResponseType represents the response type.
 * @param MappedResponseType represents the [ResponseType] that will be mapped out to ui model via [mapFromModel] function.
 * @param executorThread is [CoroutineDispatcher] which will execute the [apiCall] in.
 * @param apiCall is a service function that will fetch the data from MovieDb API.
 */
@Suppress("MaxLineLength")
suspend fun <ResponseType, MappedResponseType> safeApiCall(
    mapFromModel: ((ResponseType) -> MappedResponseType)? = null,
    executorThread: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> Response<ResponseType>
): Flow<Resource<MappedResponseType>> {

    return channelFlow {
        try {
            send(Resource.Loading())
            val response = withContext(executorThread) { apiCall() }
            if (response.isSuccessful) {
                response.body()?.let { model ->
                    send(Resource.Success(mapFromModel?.invoke(model)))
                } ?: send(
                    Resource.Error(
                        code = response.code(),
                        text = UiText.StringResource(R.string.no_result_error_message)
                    )
                )
            } else {
                val error = response.errorBody()?.parseError()
                val message = error?.message
                val code = error?.statusCode
                send(Resource.Error(code = code, text = UiText.DynamicString(message)))
            }
        } catch (exception: Exception) {
            when (exception) {
                is TimeoutException -> {
                    send(Resource.Error(text = UiText.StringResource(R.string.timeout_error_message)))
                }
                is IOException -> {
                    send(Resource.Error(text =UiText.StringResource(R.string.network_connection_error_message)
                    ))
                }
                is HttpException -> {
                    val error = exception.response()?.errorBody()?.parseError()
                    val message = error?.message
                    val code = error?.statusCode
                    send(Resource.Error(code = code, text = UiText.DynamicString(message)))
                }
                else -> {
                    exception.printStackTrace()
                    Timber.e("exception message is: %s", exception.message)
                    send(Resource.Error(text = UiText.StringResource(R.string.something_went_wrong_error_message)))
                }
            }

        }
    }
}

private fun ResponseBody.parseError(): ErrorResponse? {
    val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val type: ParameterizedType = Types.newParameterizedType(
        ErrorResponse::class.java,
        String::class.java
    )
    val adapter: JsonAdapter<ErrorResponse?> = moshi.adapter(type)
    return try {
        adapter.fromJson(string())
    } catch (exception: Exception) {
        Timber.e(exception)
        null
    }
}