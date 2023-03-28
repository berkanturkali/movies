package com.example.movies.core.network.dispatcher

import com.example.movies.core.network.utils.UrlConstants
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class SearchDispatcher : BaseDispatcher() {

    private var returnEmptyResponse = false

    private var returnErrorResponse = false
    override fun onDispatch(request: RecordedRequest): MockResponse {
        val response =
            if (returnEmptyResponse) {
                UrlConstants.EMPTY_RESPONSE
            } else if (returnErrorResponse) {
                UrlConstants.ERROR_RESPONSE
            } else {
                when (request.path) {
                    UrlConstants.COLLECTIONS_ENDPOINT -> {
                        UrlConstants.COLLECTIONS_SUCCESS_RESPONSE
                    }
                    UrlConstants.PEOPLE_ENDPOINT -> {
                        UrlConstants.PERSON_SUCCESS_RESPONSE
                    }
                    UrlConstants.MOVIES_ENDPOINT -> {
                        UrlConstants.MOVIES_SUCCESS_RESPONSE
                    }
                    UrlConstants.COMPANIES_ENDPOINT -> {
                        UrlConstants.COMPANIES_SUCCESS_RESPONSE
                    }
                    UrlConstants.KEYWORDS_ENDPOINT -> {
                        UrlConstants.KEYWORDS_SUCCESS_RESPONSE
                    }
                    UrlConstants.TV_ENDPOINT -> {
                        UrlConstants.TV_SHOWS_SUCCESS_RESPONSE
                    }
                    else -> throw IllegalArgumentException("Unknown Request Path ${request.path}")
                }
            }
        return returnSuccessResponse(response)
    }

    fun setReturnEmptyResponse(returnEmptyResponse: Boolean) {
        this.returnEmptyResponse = returnEmptyResponse
    }

    fun setReturnErrorResponse(returnErrorResponse: Boolean) {
        this.returnErrorResponse = returnErrorResponse
    }
}