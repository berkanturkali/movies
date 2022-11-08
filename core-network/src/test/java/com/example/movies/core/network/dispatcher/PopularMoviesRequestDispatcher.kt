package com.example.movies.core.network.dispatcher

import com.example.movies.core.network.factory.getJson
import com.example.movies.core.network.utils.UrlConstants
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection

class PopularMoviesRequestDispatcher : Dispatcher() {
    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            UrlConstants.POPULAR_MOVIES_ENDPOINT -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(getJson(UrlConstants.POPULAR_MOVIES_SUCCESS_RESPONSE))
            }
            else -> throw  Exception("Invalid request path ${request.path}")
        }
    }
}