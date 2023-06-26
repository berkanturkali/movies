package com.example.movies.core.network.dispatcher

import com.example.movies.core.network.utils.UrlConstants
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class MovieListDispatcher : BaseDispatcher() {
    override fun onDispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            UrlConstants.POPULAR_MOVIES_ENDPOINT -> {
                returnSuccessResponse(UrlConstants.POPULAR_MOVIES_SUCCESS_RESPONSE)
            }
            UrlConstants.NOW_PLAYING_MOVES_ENDPOINT -> {
                returnSuccessResponse(UrlConstants.NOW_PLAYING_MOVIES_SUCCESS_RESPONSE)
            }
            UrlConstants.TOP_RATED_MOVIES_ENDPOINT -> {
                returnSuccessResponse(UrlConstants.TOP_RATED_MOVIES_SUCCESS_RESPONSE)
            }
            UrlConstants.UPCOMING_MOVIES_ENDPOINT -> {
                returnSuccessResponse(UrlConstants.UPCOMING_MOVIES_SUCCESS_RESPONSE)
            }
            else -> throw Exception("Invalid request path ${request.path}")
        }
    }
}