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

    private const val UPCOMING_REQUEST_PATH: String = "/movie/upcoming"

    private const val POPULAR_REQUEST_PATH: String = "/movie/popular"

    private const val TOP_RATED_REQUEST_PATH: String = "/movie/top_rated"

    private const val SEARCH_PATH: String = "search"

    //endpoints
    const val TRENDING_MOVIES_ENDPOINT =
        "$TRENDING_REQUEST_PATH/$MEDIA_MOVIE_TYPE_PATH/$DAY_TIME_WINDOW_PATH?api_key=$API_KEY&page=$PAGE"

    const val NOW_PLAYING_MOVES_ENDPOINT = "$NOW_PLAYING_REQUEST_PATH?api_key=$API_KEY&page=$PAGE"

    const val UPCOMING_MOVIES_ENDPOINT = "$UPCOMING_REQUEST_PATH?api_key=$API_KEY&page=$PAGE"

    const val POPULAR_MOVIES_ENDPOINT = "$POPULAR_REQUEST_PATH?api_key=$API_KEY&page=$PAGE"

    const val TOP_RATED_MOVIES_ENDPOINT = "$TOP_RATED_REQUEST_PATH?api_key=$API_KEY&page=$PAGE"

    const val COMPANY_ENDPOINT = "${SEARCH_PATH}/company?page=$PAGE&query="

    const val COLLECTION_ENDPOINT = "${SEARCH_PATH}/collection?page=$PAGE&query="

    const val KEYWORD_ENDPOINT = "${SEARCH_PATH}/keyword?page=$PAGE&query="

    const val MOVIE_ENDPOINT = "${SEARCH_PATH}/movie?page=$PAGE&query="

    const val PEOPLE_ENDPOINT = "${SEARCH_PATH}/person?page=$PAGE&query="

    const val TV_ENDPOINT = "${SEARCH_PATH}/tv?page=$PAGE&query="


    //responses
    internal const val TRENDING_MOVIES_SUCCESS_RESPONSE =
        "responses/trending_movies_success_response.json"

    internal const val NOW_PLAYING_MOVIES_SUCCESS_RESPONSE =
        "responses/now_playing_movies_success_response.json"

    internal const val UPCOMING_MOVIES_SUCCESS_RESPONSE =
        "responses/upcoming_movies_success_response.json"

    internal const val POPULAR_MOVIES_SUCCESS_RESPONSE =
        "responses/popular_movies_success_response.json"

    internal const val TOP_RATED_MOVIES_SUCCESS_RESPONSE =
        "responses/top_rated_movies_success_response.json"

}