package com.example.movies.core.data.repository.trending.implementation

import com.example.movies.core.common.Resource
import com.example.movies.core.common.UiText
import com.example.movies.core.data.R
import com.example.movies.core.data.fakes.FakeExecutorThread
import com.example.movies.core.data.fakes.datasource.FakeTrendingRemoteDataSource
import com.example.movies.core.data.repository.trending.abstraction.TrendingRepository
import com.example.movies.core.network.datasource.abstraction.trending.TrendingRemoteDataSource
import com.example.movies.core.network.mapper.trending.TopTrendingMoviesResponseMapper
import com.example.movies.core.network.model.error.ErrorResponse
import com.google.common.truth.Truth
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response
import java.util.concurrent.TimeoutException

class TrendingRepositoryImplTest {

    private lateinit var trendingRemoteDataSource: TrendingRemoteDataSource

    private val topTrendingMoviesResponseMapper = TopTrendingMoviesResponseMapper()

    private val executorThread = FakeExecutorThread()

    private lateinit var repository: TrendingRepository

    @Before
    fun setup() {
        trendingRemoteDataSource = FakeTrendingRemoteDataSource()
        repository = TrendingRepositoryImpl(
            trendingRemoteDataSource = trendingRemoteDataSource,
            trendingMoviesResponseMapper = topTrendingMoviesResponseMapper,
            executorThread = executorThread
        )
    }

    @Test
    fun `check that fetchTopTrendingMovie emits loading initially`() = runBlocking {
        val resourceFlow = repository.fetchTopTrendingMovie()
        val resource = resourceFlow.toList()[0]
        Truth.assertThat(resource).isInstanceOf(Resource.Loading::class.java)
    }

    @Test
    fun `check that fetchTopTrendingMovie emits success if the response is successful and not null`() =
        runBlocking {
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setThrowException(false)
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setReturnError(false)
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setSuccessButNull(false)
            val resourceFlow = repository.fetchTopTrendingMovie()
            val resource = resourceFlow.toList()[1]
            Truth.assertThat(resource).isNotNull()
            Truth.assertThat(resource).isInstanceOf(Resource.Success::class.java)
            Truth.assertThat(resource.data).isNotNull()
            Truth.assertThat(resource.data!!.id).isEqualTo(1)
            Truth.assertThat(resource.data!!.title).isEqualTo("Lou")
        }

    @Test
    fun `check that fetchTopTrendingMovie emits error if the response is successful but null`() =
        runBlocking {
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setThrowException(false)
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setReturnError(false)
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setSuccessButNull(true)
            val resourceFlow = repository.fetchTopTrendingMovie()
            val resource = resourceFlow.toList()[1]
            Truth.assertThat(resource).isNotNull()
            Truth.assertThat(resource).isInstanceOf(Resource.Error::class.java)
            Truth.assertThat(resource.error).isNotNull()
            Truth.assertThat(resource.error).isInstanceOf(UiText.StringResource::class.java)
            Truth.assertThat((resource.error as UiText.StringResource).resId)
                .isEqualTo(R.string.no_result_error_message)
        }

    @Test
    fun `check that fetchTopTrendingMovie emits error if the response is not successful`() =
        runBlocking {
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setThrowException(false)
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setReturnError(true)
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setSuccessButNull(false)
            val resourceFlow = repository.fetchTopTrendingMovie()
            val resource = resourceFlow.toList()[1]
            Truth.assertThat(resource).isNotNull()
            Truth.assertThat(resource).isInstanceOf(Resource.Error::class.java)
            Truth.assertThat(resource.error).isNotNull()
            Truth.assertThat(resource.error).isInstanceOf(UiText.DynamicString::class.java)
            Truth.assertThat((resource.error as UiText.DynamicString).value)
                .isEqualTo("Invalidpage:Pages start at 1 and max at 1000.They are expected to be an integer.")
        }

    @Test
    fun `check that fetchTopTrendingMovie emits error with 'please check your network connection' message if io exception occurs while fetching data`() =
        runBlocking {
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setThrowException(true)
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setReturnError(false)
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setSuccessButNull(false)
            val resourceFlow = repository.fetchTopTrendingMovie()
            val resource = resourceFlow.toList()[1]
            Truth.assertThat(resource).isNotNull()
            Truth.assertThat(resource).isInstanceOf(Resource.Error::class.java)
            Truth.assertThat(resource.error).isNotNull()
            Truth.assertThat(resource.error).isInstanceOf(UiText.StringResource::class.java)
            Truth.assertThat((resource.error as UiText.StringResource).resId)
                .isEqualTo(R.string.network_connection_error_message)
        }

    @Test
    fun `check that fetchTopTrendingMovie emits error with 'Timeout' message if TimeoutException occurs while fetching the data`() =
        runBlocking {
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setException(
                TimeoutException()
            )
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setThrowException(true)
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setReturnError(false)
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setSuccessButNull(false)
            val resourceFlow = repository.fetchTopTrendingMovie()
            val resource = resourceFlow.toList()[1]
            Truth.assertThat(resource).isNotNull()
            Truth.assertThat(resource).isInstanceOf(Resource.Error::class.java)
            Truth.assertThat(resource.error).isNotNull()
            Truth.assertThat(resource.error).isInstanceOf(UiText.StringResource::class.java)
            Truth.assertThat((resource.error as UiText.StringResource).resId)
                .isEqualTo(R.string.timeout_error_message)
        }

    @Test
    fun `check that fetchTopTrendingMovie emits error with some error message if HttpException occurs while fetching the data`() =
        runBlocking {
            val errorBody = (trendingRemoteDataSource as FakeTrendingRemoteDataSource).errorResponse
                .toResponseBody(
                    "application/json".toMediaTypeOrNull()
                )
            val errorResponse: Response<ErrorResponse> = Response.error(
                401,
                errorBody,
            )
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setException(
                HttpException(errorResponse)
            )
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setThrowException(true)
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setReturnError(false)
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setSuccessButNull(false)
            val resourceFlow = repository.fetchTopTrendingMovie()
            val resource = resourceFlow.toList()[1]
            Truth.assertThat(resource).isNotNull()
            Truth.assertThat(resource).isInstanceOf(Resource.Error::class.java)
            Truth.assertThat(resource.error).isNotNull()
            Truth.assertThat(resource.error).isInstanceOf(UiText.DynamicString::class.java)
            Truth.assertThat((resource.error as UiText.DynamicString).value)
                .isEqualTo("Invalidpage:Pages start at 1 and max at 1000.They are expected to be an integer.")
        }

    @Test
    fun `check that fetchTopTrendingMovie emits error with 'Something went wrong' message if unknown exception occurs while fetching the data`() =
        runBlocking {
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setException(
                Exception()
            )
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setThrowException(true)
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setReturnError(false)
            (trendingRemoteDataSource as FakeTrendingRemoteDataSource).setSuccessButNull(false)
            val resourceFlow = repository.fetchTopTrendingMovie()
            val resource = resourceFlow.toList()[1]
            Truth.assertThat(resource).isNotNull()
            Truth.assertThat(resource).isInstanceOf(Resource.Error::class.java)
            Truth.assertThat(resource.error).isNotNull()
            Truth.assertThat(resource.error).isInstanceOf(UiText.StringResource::class.java)
            Truth.assertThat((resource.error as UiText.StringResource).resId)
                .isEqualTo(R.string.something_went_wrong_error_message)
        }
}