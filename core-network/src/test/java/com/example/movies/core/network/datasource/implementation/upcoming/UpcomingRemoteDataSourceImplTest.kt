package com.example.movies.core.network.datasource.implementation.upcoming

import com.example.movies.core.network.datasource.abstraction.upcoming.UpcomingRemoteDataSource
import com.example.movies.core.network.datasource.implementation.upcoming.UpcomingRemoteDataSourceImpl
import com.example.movies.core.network.dispatcher.UpcomingMoviesDispatcher
import com.example.movies.core.network.factory.getJson
import com.example.movies.core.network.factory.makeApiService
import com.example.movies.core.network.factory.responseAdapter
import com.example.movies.core.network.model.upcoming.UpcomingMoviesResponseDTO
import com.example.movies.core.network.service.movies.MoviesService
import com.example.movies.core.network.utils.UrlConstants
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class UpcomingRemoteDataSourceImplTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var dataSource: UpcomingRemoteDataSource

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = UpcomingMoviesDispatcher()
        mockWebServer.start()
        dataSource = UpcomingRemoteDataSourceImpl(makeApiService<MoviesService>(mockWebServer))
    }

    @Test
    fun `check that calling fetchUpcomingMovies makes a GET request`() = runBlocking {
        dataSource.fetchUpcomingMovies()
        Truth.assertThat(mockWebServer.takeRequest().method).isEqualTo("GET")
    }

    @Test
    fun `check that fetchUpcomingMovies returns correct data`() = runBlocking {
        val response = dataSource.fetchUpcomingMovies()
        val expectedResponse =
            responseAdapter<UpcomingMoviesResponseDTO, String>().fromJson(getJson(UrlConstants.UPCOMING_MOVIES_SUCCESS_RESPONSE))
        Truth.assertThat(expectedResponse).isEqualTo(response.body())
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}