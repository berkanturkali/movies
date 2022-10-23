package com.example.movies.core.network.datasource.implementation

import com.example.movies.core.network.datasource.abstraction.trending.TrendingRemoteDataSource
import com.example.movies.core.network.datasource.implementation.trending.TrendingRemoteDataSourceImpl
import com.example.movies.core.network.dispatcher.TrendingMoviesRequestDispatcher
import com.example.movies.core.network.factory.getJson
import com.example.movies.core.network.factory.makeApiService
import com.example.movies.core.network.factory.responseAdapter
import com.example.movies.core.network.model.trending.TrendingResponseDTO
import com.example.movies.core.network.utils.UrlConstants
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class TrendingRemoteDataSourceImplTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var dataSource: TrendingRemoteDataSource

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = TrendingMoviesRequestDispatcher()
        mockWebServer.start()
        dataSource = TrendingRemoteDataSourceImpl(makeApiService(mockWebServer))
    }

    @Test
    fun `check that calling fetchTopTrendingMovies makes a GET request`() = runBlocking {
        dataSource.fetchTopTrendingMovies()
        Truth.assertThat(mockWebServer.takeRequest().method).isEqualTo("GET")
    }

    @Test
    fun `check that fetchTopTrendingMovies returns correct data`() = runBlocking {
        val response = dataSource.fetchTopTrendingMovies()
        val expectedResponse =
            responseAdapter<TrendingResponseDTO, String>().fromJson(getJson(UrlConstants.TRENDING_MOVIES_SUCCESS_RESPONSE))
        Truth.assertThat(expectedResponse).isEqualTo(response.body())
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}