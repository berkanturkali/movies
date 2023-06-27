package com.example.movies.core.network.datasource.implementation.movies

import com.example.movies.core.network.datasource.abstraction.movies.MoviesRemoteDataSource
import com.example.movies.core.network.datasource.implementation.BaseDataSourceImplTest
import com.example.movies.core.network.dispatcher.BaseDispatcher
import com.example.movies.core.network.dispatcher.MoviesDispatcher
import com.example.movies.core.network.factory.getJson
import com.example.movies.core.network.factory.makeApiService
import com.example.movies.core.network.factory.responseAdapter
import com.example.movies.core.network.model.credit.CreditsResponseDTO
import com.example.movies.core.network.model.moviedetails.MovieDetailsResponseDTO
import com.example.movies.core.network.model.review.ReviewsResponseDTO
import com.example.movies.core.network.utils.UrlConstants
import com.example.movies.core.network.utils.UrlConstants.MOVIE_ID
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class MoviesRemoteDataSourceImplTest :
    BaseDataSourceImplTest<MoviesRemoteDataSource, MoviesRemoteDataSourceImpl>() {

    @Test
    fun `check that calling fetchMovie makes a GET request`() = runBlocking {
        dataSource.fetchMovie(id = MOVIE_ID)
        Truth.assertThat(mockWebServer.takeRequest().method)
            .isEqualTo("GET")
    }

    @Test
    fun `check that fetchMovie returns correct data`() = runBlocking {
        val response = dataSource.fetchMovie(MOVIE_ID)
        val expectedResponse =
            responseAdapter<MovieDetailsResponseDTO, String>().fromJson(
                getJson(UrlConstants.MOVIE_DETAILS_SUCCESS_RESPONSE)
            )
        Truth.assertThat(expectedResponse)
            .isEqualTo(response.body())
    }

    @Test
    fun `check that calling fetchCredits makes a GET request`() = runBlocking {
        dataSource.fetchCredits(id = MOVIE_ID)
        Truth.assertThat(mockWebServer.takeRequest().method)
            .isEqualTo("GET")
    }

    @Test
    fun `check that fetchCredits returns correct data`() = runBlocking {
        val response = dataSource.fetchCredits(MOVIE_ID)
        val expectedResponse =
            responseAdapter<CreditsResponseDTO, String>().fromJson(
                getJson(UrlConstants.CREDITS_SUCCESS_RESPONSE)
            )
        Truth.assertThat(expectedResponse?.cast)
            .isEqualTo(response.body()?.cast)
    }

    @Test
    fun `check that calling fetchReviews makes a GET request`() = runBlocking {
        dataSource.fetchReviews(id = MOVIE_ID, page = 1)
        Truth.assertThat(mockWebServer.takeRequest().method)
            .isEqualTo("GET")
    }

    @Test
    fun `check that fetchReviews returns correct data`() = runBlocking {
        val response = dataSource.fetchReviews(id = MOVIE_ID, page = 1)
        val expectedResponse =
            responseAdapter<ReviewsResponseDTO, String>().fromJson(
                getJson(UrlConstants.REVIEWS_SUCCESS_RESPONSE)
            )
        Truth.assertThat(expectedResponse?.results)
            .isEqualTo(response)
    }

    override fun initializeDataSource(): MoviesRemoteDataSourceImpl {
        return MoviesRemoteDataSourceImpl(makeApiService(mockWebServer))
    }

    override fun setDispatcher(): BaseDispatcher {
        return MoviesDispatcher()
    }
}