package com.example.movies.core.network.datasource.implementation.nowplaying

import com.example.movies.core.network.datasource.abstraction.nowplaying.NowPlayingRemoteDataSource
import com.example.movies.core.network.dispatcher.NowPlayingMoviesDispatcher
import com.example.movies.core.network.factory.getJson
import com.example.movies.core.network.factory.makeApiService
import com.example.movies.core.network.factory.responseAdapter
import com.example.movies.core.network.model.nowplaying.NowPlayingResponseDTO
import com.example.movies.core.network.model.trending.TrendingResponseDTO
import com.example.movies.core.network.utils.UrlConstants
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class NowPlayingRemoteDataSourceImplTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var dataSource: NowPlayingRemoteDataSource

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = NowPlayingMoviesDispatcher()
        mockWebServer.start()
        dataSource = NowPlayingRemoteDataSourceImpl(makeApiService(mockWebServer))
    }

    @Test
    fun `check that calling fetchNowPlayingMovies makes a GET request`() = runBlocking {
        dataSource.fetchNowPlayingMovies()
        Truth.assertThat(mockWebServer.takeRequest().method).isEqualTo("GET")
    }


    @Test
    fun `check that fetchNowPlayingMovies returns correct data`() = runBlocking {
        val response = dataSource.fetchNowPlayingMovies()
        val expectedResponse =
            responseAdapter<NowPlayingResponseDTO, String>().fromJson(getJson(UrlConstants.NOW_PLAYING_MOVIES_SUCCESS_RESPONSE))
        Truth.assertThat(expectedResponse).isEqualTo(response.body())
    }


    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}