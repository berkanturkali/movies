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

    private const val SEARCH_PATH: String = "/search"

    //endpoints
    const val TRENDING_MOVIES_ENDPOINT =
        "$TRENDING_REQUEST_PATH/$MEDIA_MOVIE_TYPE_PATH/$DAY_TIME_WINDOW_PATH?api_key=$API_KEY&page=$PAGE"

    const val NOW_PLAYING_MOVES_ENDPOINT = "$NOW_PLAYING_REQUEST_PATH?api_key=$API_KEY&page=$PAGE"

    const val UPCOMING_MOVIES_ENDPOINT = "$UPCOMING_REQUEST_PATH?api_key=$API_KEY&page=$PAGE"

    const val POPULAR_MOVIES_ENDPOINT = "$POPULAR_REQUEST_PATH?api_key=$API_KEY&page=$PAGE"

    const val TOP_RATED_MOVIES_ENDPOINT = "$TOP_RATED_REQUEST_PATH?api_key=$API_KEY&page=$PAGE"

    const val COMPANIES_ENDPOINT = "${SEARCH_PATH}/company?page=$PAGE&api_key=$API_KEY"

    const val COLLECTIONS_ENDPOINT = "${SEARCH_PATH}/collection?page=$PAGE&api_key=$API_KEY"

    const val KEYWORDS_ENDPOINT = "${SEARCH_PATH}/keyword?page=$PAGE&api_key=$API_KEY"

    const val MOVIES_ENDPOINT = "${SEARCH_PATH}/movie?page=$PAGE&api_key=$API_KEY"

    const val PEOPLE_ENDPOINT = "${SEARCH_PATH}/person?page=$PAGE&api_key=$API_KEY"

    const val TV_ENDPOINT = "${SEARCH_PATH}/tv?page=$PAGE&api_key=$API_KEY"


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

    internal val COLLECTIONS_SUCCESS_RESPONSE = getSuccessResponsePath("collections")

    internal val COMPANIES_SUCCESS_RESPONSE = getSuccessResponsePath("companies")

    internal val KEYWORDS_SUCCESS_RESPONSE = getSuccessResponsePath("keywords")

    internal val MOVIES_SUCCESS_RESPONSE = getSuccessResponsePath("movies")

    internal val PERSON_SUCCESS_RESPONSE = getSuccessResponsePath("person")

    internal val TV_SHOWS_SUCCESS_RESPONSE = getSuccessResponsePath("tv_shows")


    private fun getSuccessResponsePath(name: String): String =
        "responses/${name}_success_response.json"

}