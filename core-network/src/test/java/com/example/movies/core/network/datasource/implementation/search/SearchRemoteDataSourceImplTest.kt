package com.example.movies.core.network.datasource.implementation.search

import com.example.movies.core.network.datasource.abstraction.search.SearchRemoteDataSource
import com.example.movies.core.network.datasource.implementation.BaseDataSourceImplTest
import com.example.movies.core.network.dispatcher.BaseDispatcher
import com.example.movies.core.network.dispatcher.SearchDispatcher
import com.example.movies.core.network.factory.getJson
import com.example.movies.core.network.factory.makeApiService
import com.example.movies.core.network.factory.responseAdapter
import com.example.movies.core.network.model.search.collection.CollectionsResponseDTO
import com.example.movies.core.network.model.search.company.CompaniesResponseDTO
import com.example.movies.core.network.model.search.keyword.KeywordsResponseDTO
import com.example.movies.core.network.model.search.movie.MoviesResponseDTO
import com.example.movies.core.network.model.search.people.PeopleResponseDTO
import com.example.movies.core.network.model.search.tvshow.TvShowsResponseDTO
import com.example.movies.core.network.utils.UrlConstants
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class SearchRemoteDataSourceImplTest :
    BaseDataSourceImplTest<SearchRemoteDataSource, SearchRemoteDataSourceImpl>() {

    private val page = 1

    private val searchQuery: String? = null
    override fun initializeDataSource(): SearchRemoteDataSourceImpl {
        return SearchRemoteDataSourceImpl(makeApiService(mockWebServer))
    }

    @Test
    fun `check that fetchCompanies makes a GET request`() {
        `check that the request is a GET request`(apiRequest = dataSource::fetchCompanies)
    }

    @Test
    fun `check that fetchCollections makes a GET request`() = runBlocking {
        `check that the request is a GET request`(apiRequest = dataSource::fetchCollections)
    }

    @Test
    fun `check that fetchKeywords makes a GET request`() = runBlocking {
        `check that the request is a GET request`(apiRequest = dataSource::fetchKeywords)

    }

    @Test
    fun `check that fetchMovies makes a GET request`() = runBlocking {
        `check that the request is a GET request`(apiRequest = dataSource::fetchMovies)
    }

    @Test
    fun `check that fetchPeople makes a GET request`() = runBlocking {
        `check that the request is a GET request`(apiRequest = dataSource::fetchPeople)
    }

    @Test
    fun `check that fetchCompanies returns correct data`() = runBlocking {
        val response = dataSource.fetchCompanies(page, query = null)
        val expectedResponse = responseAdapter<CompaniesResponseDTO, String>().fromJson(
            getJson(UrlConstants.COMPANIES_SUCCESS_RESPONSE)
        )

        Truth.assertThat(expectedResponse?.companies)
            .isEqualTo(response)
    }

    @Test
    fun `check that fetchCollections returns correct data`() = runBlocking {
        val response = dataSource.fetchCollections(page, query = null)
        val expectedResponse = responseAdapter<CollectionsResponseDTO, String>().fromJson(
            getJson(UrlConstants.COLLECTIONS_SUCCESS_RESPONSE)
        )

        Truth.assertThat(expectedResponse?.collections)
            .isEqualTo(response)
    }

    @Test
    fun `check that fetchKeywords returns correct data`() = runBlocking {
        val response = dataSource.fetchKeywords(page, query = null)
        val expectedResponse = responseAdapter<KeywordsResponseDTO, String>().fromJson(
            getJson(UrlConstants.KEYWORDS_SUCCESS_RESPONSE)
        )

        Truth.assertThat(expectedResponse?.keywords)
            .isEqualTo(response)
    }

    @Test
    fun `check that fetchMovies returns correct data`() = runBlocking {
        val response = dataSource.fetchMovies(page, query = null)
        val expectedResponse = responseAdapter<MoviesResponseDTO, String>().fromJson(
            getJson(UrlConstants.MOVIES_SUCCESS_RESPONSE)
        )

        Truth.assertThat(expectedResponse?.movies)
            .isEqualTo(response)
    }

    @Test
    fun `check that fetchPeople returns correct data`() = runBlocking {
        val response = dataSource.fetchPeople(page, query = null)
        val expectedResponse = responseAdapter<PeopleResponseDTO, String>().fromJson(
            getJson(UrlConstants.PERSON_SUCCESS_RESPONSE)
        )

        Truth.assertThat(expectedResponse?.people)
            .isEqualTo(response)
    }

    @Test
    fun `check that fetchTvShow returns correct data`() = runBlocking {
        val response = dataSource.fetchTvShow(page, query = null)
        val expectedResponse = responseAdapter<TvShowsResponseDTO, String>().fromJson(
            getJson(UrlConstants.TV_SHOWS_SUCCESS_RESPONSE)
        )

        Truth.assertThat(expectedResponse?.shows)
            .isEqualTo(response)
    }


    private fun `check that the request is a GET request`(apiRequest: suspend (Int, String?) -> Unit) =
        runBlocking {
            apiRequest.invoke(page, searchQuery)
            Truth.assertThat(mockWebServer.takeRequest().method)
                .isEqualTo("GET")
        }

    override fun setDispatcher(): BaseDispatcher {
        return SearchDispatcher()
    }

}