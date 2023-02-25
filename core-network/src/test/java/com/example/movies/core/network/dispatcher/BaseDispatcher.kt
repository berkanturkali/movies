package com.example.movies.core.network.dispatcher

import com.example.movies.core.network.factory.getJson
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection

abstract class BaseDispatcher : Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        return onDispatch(request)
    }

    abstract fun onDispatch(request: RecordedRequest): MockResponse

    protected fun returnSuccessResponse(response: String): MockResponse {
        return MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(getJson(response))
    }
}