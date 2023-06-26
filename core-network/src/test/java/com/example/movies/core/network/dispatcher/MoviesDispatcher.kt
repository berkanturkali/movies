package com.example.movies.core.network.dispatcher

import com.example.movies.core.network.utils.UrlConstants.CREDITS_ENDPOINT
import com.example.movies.core.network.utils.UrlConstants.CREDITS_SUCCESS_RESPONSE
import com.example.movies.core.network.utils.UrlConstants.MOVIE_DETAILS_ENDPOINT
import com.example.movies.core.network.utils.UrlConstants.MOVIE_DETAILS_SUCCESS_RESPONSE
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class MoviesDispatcher : BaseDispatcher() {
    override fun onDispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            MOVIE_DETAILS_ENDPOINT -> {
                returnSuccessResponse(MOVIE_DETAILS_SUCCESS_RESPONSE)
            }
            CREDITS_ENDPOINT -> {
                returnSuccessResponse(CREDITS_SUCCESS_RESPONSE)
            }
            else -> throw Exception("Invalid request path ${request.path}")
        }
    }
}