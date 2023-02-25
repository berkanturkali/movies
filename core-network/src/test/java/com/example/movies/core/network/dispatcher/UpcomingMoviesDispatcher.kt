package com.example.movies.core.network.dispatcher

import com.example.movies.core.network.utils.UrlConstants
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class UpcomingMoviesDispatcher : BaseDispatcher() {
    override fun onDispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            UrlConstants.UPCOMING_MOVIES_ENDPOINT -> {
                returnSuccessResponse(UrlConstants.UPCOMING_MOVIES_SUCCESS_RESPONSE)
            }
            else -> throw IllegalArgumentException("Unknown Request Path ${request.path}")
        }
    }
}