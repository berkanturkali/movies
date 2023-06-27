package com.example.movies.core.network.dispatcher

import com.example.movies.core.network.factory.getJson
import com.example.movies.core.network.utils.UrlConstants
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection

abstract class BaseDispatcher : Dispatcher() {

    private var returnEmptyResponse = false

    private var returnErrorResponse = false
    override fun dispatch(request: RecordedRequest): MockResponse {
        val response = if (returnEmptyResponse) {
            UrlConstants.EMPTY_RESPONSE
        } else if (returnErrorResponse) {
            UrlConstants.ERROR_RESPONSE
        } else {
            onDispatch(request)
        }
        return returnSuccessResponse(response)
    }

    abstract fun onDispatch(request: RecordedRequest): String

    protected fun returnSuccessResponse(response: String): MockResponse {
        return MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(getJson(response))
    }

    fun setReturnEmptyResponse(returnEmptyResponse: Boolean) {
        this.returnEmptyResponse = returnEmptyResponse
    }

    fun setReturnErrorResponse(returnErrorResponse: Boolean) {
        this.returnErrorResponse = returnErrorResponse
    }
}