package com.example.movies.core.network.dispatcher

import com.example.movies.core.network.factory.getJson
import com.example.movies.core.network.utils.UrlConstants
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection

class UpcomingMoviesDispatcher : Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            UrlConstants.UPCOMING_MOVIES_ENDPOINT -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(getJson(UrlConstants.UPCOMING_MOVIES_SUCCESS_RESPONSE))
            }
            else -> throw IllegalArgumentException("Unknown Request Path ${request.path}")
        }
    }
}