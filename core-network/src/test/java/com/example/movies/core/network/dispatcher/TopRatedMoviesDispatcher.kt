package com.example.movies.core.network.dispatcher

import com.example.movies.core.network.utils.UrlConstants
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class TopRatedMoviesDispatcher : BaseDispatcher() {
    override fun onDispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            UrlConstants.TOP_RATED_MOVIES_ENDPOINT -> {
                returnSuccessResponse(UrlConstants.TOP_RATED_MOVIES_SUCCESS_RESPONSE)
            }
            else -> throw  Exception("Invalid request path ${request.path}")
        }
    }
}