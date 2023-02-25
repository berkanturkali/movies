package com.example.movies.core.network.datasource.implementation

import com.example.movies.core.network.datasource.abstraction.top_rated.TopRatedMoviesRemoteDataSource
import com.example.movies.core.network.datasource.implementation.top_rated.TopRatedMoviesRemoteDataSourceImpl
import com.example.movies.core.network.dispatcher.BaseDispatcher
import com.example.movies.core.network.dispatcher.TopRatedMoviesDispatcher
import com.example.movies.core.network.factory.getJson
import com.example.movies.core.network.factory.makeApiService
import com.example.movies.core.network.factory.responseAdapter
import com.example.movies.core.network.model.top_rated.TopRatedMoviesResponseDTO
import com.example.movies.core.network.utils.UrlConstants
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class TopRatedMoviesRemoteDataSourceImplTest :
    BaseDataSourceImplTest<TopRatedMoviesRemoteDataSource, TopRatedMoviesRemoteDataSourceImpl>() {

    override fun initializeDataSource(): TopRatedMoviesRemoteDataSourceImpl {
        return TopRatedMoviesRemoteDataSourceImpl(makeApiService(mockWebServer))
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


    override fun setDispatcher(): BaseDispatcher {
        return TopRatedMoviesDispatcher()
    }

}