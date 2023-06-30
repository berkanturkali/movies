package com.example.movies.core.network.dispatcher

import com.example.movies.core.network.utils.UrlConstants.CREDITS_ENDPOINT
import com.example.movies.core.network.utils.UrlConstants.CREDITS_SUCCESS_RESPONSE
import com.example.movies.core.network.utils.UrlConstants.KEYWORDS_FOR_DETAILS_ENDPOINT
import com.example.movies.core.network.utils.UrlConstants.KEYWORDS_FOR_DETAILS_RESPONSE
import com.example.movies.core.network.utils.UrlConstants.MOVIE_DETAILS_ENDPOINT
import com.example.movies.core.network.utils.UrlConstants.MOVIE_DETAILS_SUCCESS_RESPONSE
import com.example.movies.core.network.utils.UrlConstants.RECOMMENDATIONS_ENDPOINT
import com.example.movies.core.network.utils.UrlConstants.RECOMMENDATIONS_SUCCESS_RESPONSE
import com.example.movies.core.network.utils.UrlConstants.REVIEWS_ENDPOINT
import com.example.movies.core.network.utils.UrlConstants.REVIEWS_SUCCESS_RESPONSE
import com.example.movies.core.network.utils.UrlConstants.VIDEOS_ENDPOINT
import com.example.movies.core.network.utils.UrlConstants.VIDEOS_SUCCESS_RESPONSE
import okhttp3.mockwebserver.RecordedRequest

class MoviesDispatcher : BaseDispatcher() {
    override fun onDispatch(request: RecordedRequest): String {
        return when (request.path) {
            MOVIE_DETAILS_ENDPOINT -> {
                MOVIE_DETAILS_SUCCESS_RESPONSE
            }
            CREDITS_ENDPOINT -> {
                CREDITS_SUCCESS_RESPONSE
            }
            REVIEWS_ENDPOINT -> {
                REVIEWS_SUCCESS_RESPONSE
            }
            KEYWORDS_FOR_DETAILS_ENDPOINT -> {
                KEYWORDS_FOR_DETAILS_RESPONSE
            }
            VIDEOS_ENDPOINT -> {
                VIDEOS_SUCCESS_RESPONSE
            }
            RECOMMENDATIONS_ENDPOINT -> {
                RECOMMENDATIONS_SUCCESS_RESPONSE
            }
            else -> throw Exception("Invalid request path ${request.path}")
        }
    }
}