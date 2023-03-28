package com.example.movies.core.network.pagination.search.tv_shows

import androidx.paging.PagingSource
import com.example.movies.core.network.datasource.abstraction.search.SearchRemoteDataSource
import com.example.movies.core.network.datasource.implementation.search.SearchRemoteDataSourceImpl
import com.example.movies.core.network.dispatcher.SearchDispatcher
import com.example.movies.core.network.factory.makeApiService
import com.example.movies.core.network.pagination.search.movies.MoviesPagingSource
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class TvShowsPagingSourceTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var remoteDataSource: SearchRemoteDataSource

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = SearchDispatcher()
        mockWebServer.start()
        remoteDataSource = SearchRemoteDataSourceImpl(makeApiService(mockWebServer = mockWebServer))
    }

    @Test
    fun `check that prev and next keys are correct`() = runBlocking {
        val pagingSource = TvShowsPagingSource(remoteDataSource, null)
        val shows = remoteDataSource.fetchTvShow(1, null)
        Truth.assertThat(
            PagingSource.LoadResult.Page(
                data = shows,
                prevKey = null,
                nextKey = 2
            )
        )
            .isEqualTo(
                pagingSource.load(
                    PagingSource.LoadParams.Refresh(
                        key = null,
                        loadSize = 20,
                        placeholdersEnabled = false
                    )
                )
            )
    }

    @Test
    fun `check that prev and next keys are correct when the list is empty`() =
        runBlocking {
            (mockWebServer.dispatcher as SearchDispatcher).setReturnEmptyResponse(true)
            val pagingSource = TvShowsPagingSource(remoteDataSource, null)
            Truth.assertThat(
                pagingSource.load(
                    PagingSource.LoadParams.Refresh(
                        key = 1,
                        loadSize = 20,
                        placeholdersEnabled = false
                    )
                )
            )
                .isEqualTo(
                    PagingSource.LoadResult.Page(
                        data = emptyList(),
                        prevKey = null,
                        nextKey = null
                    )
                )
        }

    @Test
    fun `check that paging source returns error when error occurs`() = runBlocking {
        val remoteDataSource = mockk<SearchRemoteDataSource>()
        coEvery { remoteDataSource.fetchTvShow(1, null) } throws Exception()
        val pagingSource = TvShowsPagingSource(remoteDataSource, null)
        val result = pagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 20,
                placeholdersEnabled = false
            )
        )
        Truth.assertThat(result)
            .isInstanceOf(PagingSource.LoadResult.Error::class.java)
        Truth.assertThat((result as PagingSource.LoadResult.Error).throwable.message)
            .isEqualTo("Something went wrong")
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}