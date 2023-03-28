package com.example.movies.core.network.dispatcher

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class SearchDispatcher : BaseDispatcher() {
    override fun onDispatch(request: RecordedRequest): MockResponse {
        when (request.path) {

            else -> throw IllegalArgumentException("Unknown Request Path ${request.path}")
        }
    }
}