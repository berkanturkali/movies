package com.example.movies.core.network.utils

import com.example.movies.core.network.BuildConfig

object UrlConstants {

    private const val MEDIA_MOVIE_TYPE_PATH = "movie"

    private const val DAY_TIME_WINDOW_PATH = "day"

    private const val API_KEY = BuildConfig.API_KEY

    private const val PAGE = 1

    //paths
    private const val TRENDING_REQUEST_PATH: String =
        "/trending"


    //endpoints
    const val TRENDING_MOVIES_ENDPOINT =
        "$TRENDING_REQUEST_PATH/$MEDIA_MOVIE_TYPE_PATH/$DAY_TIME_WINDOW_PATH?api_key=$API_KEY&page=$PAGE"


    //responses
    internal const val TRENDING_MOVIES_SUCCESS_RESPONSE =
        "responses/trending_movies_success_response.json"

}