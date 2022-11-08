package com.example.movies.core.network.datasource.implementation.popular

import com.example.movies.core.network.datasource.abstraction.popular.PopularRemoteDataSource
import com.example.movies.core.network.dispatcher.PopularMoviesRequestDispatcher
import com.example.movies.core.network.factory.getJson
import com.example.movies.core.network.factory.makeApiService
import com.example.movies.core.network.factory.responseAdapter
import com.example.movies.core.network.model.popular.PopularMoviesResponseDTO
import com.example.movies.core.network.utils.UrlConstants
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class PopularRemoteDataSourceImplTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var dataSource: PopularRemoteDataSource

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = PopularMoviesRequestDispatcher()
        mockWebServer.start()
        dataSource = PopularRemoteDataSourceImpl(makeApiService(mockWebServer))
    }

    @Test
    fun `check that calling fetchPopularMovies makes a GET request`() = runBlocking {
        dataSource.fetchPopularMovies()
        Truth.assertThat(mockWebServer.takeRequest().method).isEqualTo("GET")
    }

    @Test
    fun `check that fetchPopularMovies returns correct data`() = runBlocking {
        val response = dataSource.fetchPopularMovies()
        val expectedResponse =
            responseAdapter<PopularMoviesResponseDTO, String>().fromJson(getJson(UrlConstants.POPULAR_MOVIES_SUCCESS_RESPONSE))
        Truth.assertThat(expectedResponse).isEqualTo(response.body())
    }


    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}