package com.example.movies.core.data.repository.nowplaying.abstraction

interface NowPlayingRepository {

    suspend fun fetchNowPlayingMovies()
}