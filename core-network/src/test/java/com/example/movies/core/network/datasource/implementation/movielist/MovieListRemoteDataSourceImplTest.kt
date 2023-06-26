package com.example.movies.core.network.datasource.implementation.movielist

import com.example.movies.core.network.datasource.abstraction.movielist.MovieListRemoteDataSource
import com.example.movies.core.network.datasource.implementation.BaseDataSourceImplTest
import com.example.movies.core.network.dispatcher.BaseDispatcher
import com.example.movies.core.network.dispatcher.MovieListDispatcher
import com.example.movies.core.network.factory.getJson
import com.example.movies.core.network.factory.makeApiService
import com.example.movies.core.network.factory.responseAdapter
import com.example.movies.core.network.model.nowplaying.NowPlayingResponseDTO
import com.example.movies.core.network.model.popular.PopularMoviesResponseDTO
import com.example.movies.core.network.model.toprated.TopRatedMoviesResponseDTO
import com.example.movies.core.network.model.upcoming.UpcomingMoviesResponseDTO
import com.example.movies.core.network.utils.UrlConstants
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class MovieListRemoteDataSourceImplTest :
    BaseDataSourceImplTest<MovieListRemoteDataSource, MovieListRemoteDataSourceImpl>() {


    @Test
    fun `check that calling fetchNowPlayingMovies makes a GET request`() = runBlocking {
        dataSource.fetchNowPlayingMovies()
        Truth.assertThat(mockWebServer.takeRequest().method)
            .isEqualTo("GET")
    }


    @Test
    fun `check that fetchNowPlayingMovies returns correct data`() = runBlocking {
        val response = dataSource.fetchNowPlayingMovies()
        val expectedResponse =
            responseAdapter<NowPlayingResponseDTO, String>().fromJson(
                getJson(UrlConstants.NOW_PLAYING_MOVIES_SUCCESS_RESPONSE)
            )
        Truth.assertThat(expectedResponse)
            .isEqualTo(response.body())
    }

    @Test
    fun `check that calling fetchPopularMovies makes a GET request`() = runBlocking {
        dataSource.fetchPopularMovies()
        Truth.assertThat(mockWebServer.takeRequest().method)
            .isEqualTo("GET")
    }

    @Test
    fun `check that fetchPopularMovies returns correct data`() = runBlocking {
        val response = dataSource.fetchPopularMovies()
        val expectedResponse =
            responseAdapter<PopularMoviesResponseDTO, String>().fromJson(
                getJson(UrlConstants.POPULAR_MOVIES_SUCCESS_RESPONSE)
            )
        Truth.assertThat(expectedResponse)
            .isEqualTo(response.body())
    }

    @Test
    fun `check that calling fetchUpcomingMovies makes a GET request`() = runBlocking {
        dataSource.fetchUpcomingMovies()
        Truth.assertThat(mockWebServer.takeRequest().method)
            .isEqualTo("GET")
    }

    @Test
    fun `check that fetchUpcomingMovies returns correct data`() = runBlocking {
        val response = dataSource.fetchUpcomingMovies()
        val expectedResponse =
            responseAdapter<UpcomingMoviesResponseDTO, String>().fromJson(
                getJson(UrlConstants.UPCOMING_MOVIES_SUCCESS_RESPONSE)
            )
        Truth.assertThat(expectedResponse)
            .isEqualTo(response.body())
    }

    @Test
    fun `check that calling fetchTopRatedMovies makes a GET request`() = runBlocking {
        dataSource.fetchTopRatedMovies()
        Truth.assertThat(mockWebServer.takeRequest().method)
            .isEqualTo("GET")
    }

    @Test
    fun `check that fetchTopRatedMovies returns correct data`() = runBlocking {
        val response = dataSource.fetchTopRatedMovies()
        val expectedResponse = responseAdapter<TopRatedMoviesResponseDTO, String>().fromJson(
            getJson(UrlConstants.TOP_RATED_MOVIES_SUCCESS_RESPONSE)
        )

        Truth.assertThat(expectedResponse)
            .isEqualTo(response.body())
    }

    override fun initializeDataSource(): MovieListRemoteDataSourceImpl {
        return MovieListRemoteDataSourceImpl(makeApiService(mockWebServer))
    }

    override fun setDispatcher(): BaseDispatcher {
        return MovieListDispatcher()
    }
}