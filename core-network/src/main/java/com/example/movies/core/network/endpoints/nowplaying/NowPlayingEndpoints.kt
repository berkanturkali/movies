package com.example.movies.core.network.endpoints.nowplaying

object NowPlayingEndpoints {

    private const val MOVIE_PATH = "movie"

    private const val NOW_PLAYING_PATH = "$MOVIE_PATH/now_playing"

    private const val UPCOMING_PATH = "$MOVIE_PATH/upcoming"

    const val NOW_PLAYING_MOVIES_ENDPOINT = NOW_PLAYING_PATH

    const val UPCOMING_MOVIES_ENDPOINT = UPCOMING_PATH
}