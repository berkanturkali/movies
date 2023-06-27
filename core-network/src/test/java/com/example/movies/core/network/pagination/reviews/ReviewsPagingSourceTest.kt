package com.example.movies.core.network.pagination.reviews

import androidx.paging.PagingSource
import com.example.movies.core.network.datasource.abstraction.movies.MoviesRemoteDataSource
import com.example.movies.core.network.datasource.implementation.movies.MoviesRemoteDataSourceImpl
import com.example.movies.core.network.dispatcher.MoviesDispatcher
import com.example.movies.core.network.factory.makeApiService
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test

class ReviewsPagingSourceTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var remoteDataSource: MoviesRemoteDataSource

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = MoviesDispatcher()
        mockWebServer.start()
        remoteDataSource = MoviesRemoteDataSourceImpl(makeApiService(mockWebServer = mockWebServer))
    }


    @Test
    fun `check that prev and next keys are correct`() = runBlocking {
        val pagingSource = ReviewsPagingSource(remoteDataSource, 1)
        val reviews = remoteDataSource.fetchReviews(1, 1)
        Truth.assertThat(
            PagingSource.LoadResult.Page(
                data = reviews,
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
    fun `check that prev and next keys are correct when the list is empty`() = runBlocking {
        (mockWebServer.dispatcher as MoviesDispatcher).setReturnEmptyResponse(true)
        val pagingSource = ReviewsPagingSource(remoteDataSource, 1)
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
        val remoteDataSource = mockk<MoviesRemoteDataSource>()
        coEvery { remoteDataSource.fetchReviews(1, 1) } throws Exception()
        val pagingSource = ReviewsPagingSource(remoteDataSource, 1)
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