package com.example.movies.core.network.endpoints.movies

object MoviesEndpoints {

    private const val MOVIE_PATH = "movie"

    private const val NOW_PLAYING_PATH = "$MOVIE_PATH/now_playing"

    private const val UPCOMING_PATH = "$MOVIE_PATH/upcoming"

    private const val POPULAR_PATH = "$MOVIE_PATH/popular"

    const val NOW_PLAYING_MOVIES_ENDPOINT = NOW_PLAYING_PATH

    const val UPCOMING_MOVIES_ENDPOINT = UPCOMING_PATH

    const val POPULAR_MOVIES_ENDPOINT = POPULAR_PATH

    const val TOP_RATED_MOVIES_ENDPOINT = "$MOVIE_PATH/top_rated"

    const val MOVIE_DETAILS_ENDPOINT = "$MOVIE_PATH/{movie_id}"

    const val CREDITS_ENDPOINT = "$MOVIE_DETAILS_ENDPOINT/credits"
}