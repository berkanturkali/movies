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

    private const val NOW_PLAYING_REQUEST_PATH: String = "/movie/now_playing"


    //endpoints
    const val TRENDING_MOVIES_ENDPOINT =
        "$TRENDING_REQUEST_PATH/$MEDIA_MOVIE_TYPE_PATH/$DAY_TIME_WINDOW_PATH?api_key=$API_KEY&page=$PAGE"

    const val NOW_PLAYING_MOVES_ENDPOINT = "$NOW_PLAYING_REQUEST_PATH?api_key=$API_KEY&page=$PAGE"


    //responses
    internal const val TRENDING_MOVIES_SUCCESS_RESPONSE =
        "responses/trending_movies_success_response.json"

    internal const val NOW_PLAYING_MOVIES_SUCCESS_RESPONSE =
        "responses/now_playing_movies_success_response.json"

}