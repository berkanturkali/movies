package com.example.movies.core.network.dispatcher

import com.example.movies.core.network.utils.UrlConstants
import com.example.movies.core.network.utils.UrlConstants.TRENDING_MOVIES_SUCCESS_RESPONSE
import okhttp3.mockwebserver.RecordedRequest

class TrendingMoviesRequestDispatcher : BaseDispatcher() {
    override fun onDispatch(request: RecordedRequest): String {
        return when (request.path) {
            UrlConstants.TRENDING_MOVIES_ENDPOINT -> {
                TRENDING_MOVIES_SUCCESS_RESPONSE
            }
            else -> throw IllegalArgumentException("Unknown Request Path ${request.path}")
        }
    }
}