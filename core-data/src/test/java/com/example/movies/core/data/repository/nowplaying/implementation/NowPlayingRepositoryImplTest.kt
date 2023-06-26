//package com.example.movies.core.data.repository.nowplaying.implementation
//
//import com.example.movies.core.common.Resource
//import com.example.movies.core.common.UiText
//import com.example.movies.core.data.R
//import com.example.movies.core.data.fakes.FakeExecutorThread
//import com.example.movies.core.data.fakes.datasource.FakeNowPlayingRemoteDataSource
//import com.example.movies.core.data.repository.movies.abstraction.MoviesRepository
//import com.example.movies.core.network.datasource.abstraction.movies.MoviesRemoteDataSource
//import com.example.movies.core.network.mapper.nowplaying.NowPlayingMoviesResponseMapper
//import com.example.movies.core.network.model.error.ErrorResponse
//import com.google.common.truth.Truth
//import kotlinx.coroutines.flow.toList
//import kotlinx.coroutines.runBlocking
//import okhttp3.MediaType.Companion.toMediaTypeOrNull
//import okhttp3.ResponseBody.Companion.toResponseBody
//import org.junit.Before
//import org.junit.Test
//import retrofit2.HttpException
//import retrofit2.Response
//import java.util.concurrent.TimeoutException
//
//class NowPlayingRepositoryImplTest {
//
//    private lateinit var nowPlayingRemoteDataSource: MoviesRemoteDataSource
//
//    private val nowPlayingMoviesResponseMapper = NowPlayingMoviesResponseMapper()
//
//    private val executorThread = FakeExecutorThread()
//
//    private lateinit var repository: MoviesRepository
//
//    @Before
//    fun setup() {
//        nowPlayingRemoteDataSource = FakeNowPlayingRemoteDataSource()
//        repository = MoviesRepositoryImpl(
//            nowPlayingMoviesResponseMapper = nowPlayingMoviesResponseMapper,
//            nowPlayingRemoteDataSource = nowPlayingRemoteDataSource,
//            executorThread = executorThread,
//        )
//    }
//
//    @Test
//    fun `check that fetchNowPlayingMovies emits loading initially`() = runBlocking {
//        val resourceFlow = repository.fetchNowPlayingMovies()
//        val resource = resourceFlow.toList()[0]
//        Truth.assertThat(resource).isInstanceOf(Resource.Loading::class.java)
//    }
//
//    @Test
//    fun `check that fetchNowPlayingMovies emits success if the response is successful and not null`() =
//        runBlocking {
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setThrowException(false)
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setReturnError(false)
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setSuccessButNull(false)
//            val resourceFlow = repository.fetchNowPlayingMovies()
//            val resource = resourceFlow.toList()[1]
//            Truth.assertThat(resource).isNotNull()
//            Truth.assertThat(resource).isInstanceOf(Resource.Success::class.java)
//            Truth.assertThat(resource.data).isNotNull()
//            Truth.assertThat(resource.data!![0].id).isEqualTo(436270)
//            Truth.assertThat(resource.data!![0].title).isEqualTo("Black Adam")
//            Truth.assertThat(resource.data!![0].description)
//                .isEqualTo("Nearly 5,000 years after he was bestowed with the almighty powers of the Egyptian gods—and imprisoned just as quickly—Black Adam is freed from his earthly tomb, ready to unleash his unique form of justice on the modern world.")
//        }
//
//    @Test
//    fun `check that fetchNowPlayingMovies emits error if the response is successful but null`() =
//        runBlocking {
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setThrowException(false)
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setReturnError(false)
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setSuccessButNull(true)
//            val resourceFlow = repository.fetchNowPlayingMovies()
//            val resource = resourceFlow.toList()[1]
//            Truth.assertThat(resource).isNotNull()
//            Truth.assertThat(resource).isInstanceOf(Resource.Error::class.java)
//            Truth.assertThat(resource.error).isNotNull()
//            Truth.assertThat(resource.error).isInstanceOf(UiText.StringResource::class.java)
//            Truth.assertThat((resource.error as UiText.StringResource).resId)
//                .isEqualTo(R.string.no_result_error_message)
//        }
//
//    @Test
//    fun `check that fetchNowPlayingMovies emits error if the response is not successful`() =
//        runBlocking {
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setThrowException(false)
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setReturnError(true)
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setSuccessButNull(false)
//            val resourceFlow = repository.fetchNowPlayingMovies()
//            val resource = resourceFlow.toList()[1]
//            Truth.assertThat(resource).isNotNull()
//            Truth.assertThat(resource).isInstanceOf(Resource.Error::class.java)
//            Truth.assertThat(resource.error).isNotNull()
//            Truth.assertThat(resource.error).isInstanceOf(UiText.DynamicString::class.java)
//            Truth.assertThat((resource.error as UiText.DynamicString).value)
//                .isEqualTo("Invalidpage:Pages start at 1 and max at 1000.They are expected to be an integer.")
//        }
//
//    @Test
//    fun `check that fetchNowPlayingMovies emits error with 'please check your network connection' message if io exception occurs while fetching data`() =
//        runBlocking {
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setThrowException(true)
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setReturnError(false)
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setSuccessButNull(false)
//            val resourceFlow = repository.fetchNowPlayingMovies()
//            val resource = resourceFlow.toList()[1]
//            Truth.assertThat(resource).isNotNull()
//            Truth.assertThat(resource).isInstanceOf(Resource.Error::class.java)
//            Truth.assertThat(resource.error).isNotNull()
//            Truth.assertThat(resource.error).isInstanceOf(UiText.StringResource::class.java)
//            Truth.assertThat((resource.error as UiText.StringResource).resId)
//                .isEqualTo(R.string.network_connection_error_message)
//        }
//
//    @Test
//    fun `check that fetchNowPlayingMovies emits error with 'Timeout' message if TimeoutException occurs while fetching the data`() =
//        runBlocking {
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setException(
//                TimeoutException()
//            )
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setThrowException(true)
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setReturnError(false)
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setSuccessButNull(false)
//            val resourceFlow = repository.fetchNowPlayingMovies()
//            val resource = resourceFlow.toList()[1]
//            Truth.assertThat(resource).isNotNull()
//            Truth.assertThat(resource).isInstanceOf(Resource.Error::class.java)
//            Truth.assertThat(resource.error).isNotNull()
//            Truth.assertThat(resource.error).isInstanceOf(UiText.StringResource::class.java)
//            Truth.assertThat((resource.error as UiText.StringResource).resId)
//                .isEqualTo(R.string.timeout_error_message)
//        }
//
//    @Test
//    fun `check that fetchNowPlayingMovies emits error with some error message if HttpException occurs while fetching the data`() =
//        runBlocking {
//            val errorBody =
//                (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).errorResponse
//                    .toResponseBody(
//                        "application/json".toMediaTypeOrNull()
//                    )
//            val errorResponse: Response<ErrorResponse> = Response.error(
//                401,
//                errorBody,
//            )
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setException(
//                HttpException(errorResponse)
//            )
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setThrowException(true)
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setReturnError(false)
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setSuccessButNull(false)
//            val resourceFlow = repository.fetchNowPlayingMovies()
//            val resource = resourceFlow.toList()[1]
//            Truth.assertThat(resource).isNotNull()
//            Truth.assertThat(resource).isInstanceOf(Resource.Error::class.java)
//            Truth.assertThat(resource.error).isNotNull()
//            Truth.assertThat(resource.error).isInstanceOf(UiText.DynamicString::class.java)
//            Truth.assertThat((resource.error as UiText.DynamicString).value)
//                .isEqualTo("Invalidpage:Pages start at 1 and max at 1000.They are expected to be an integer.")
//        }
//
//    @Test
//    fun `check that fetchNowPlayingMovies emits error with 'Something went wrong' message if unknown exception occurs while fetching the data`() =
//        runBlocking {
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setException(
//                Exception()
//            )
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setThrowException(true)
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setReturnError(false)
//            (nowPlayingRemoteDataSource as FakeNowPlayingRemoteDataSource).setSuccessButNull(false)
//            val resourceFlow = repository.fetchNowPlayingMovies()
//            val resource = resourceFlow.toList()[1]
//            Truth.assertThat(resource).isNotNull()
//            Truth.assertThat(resource).isInstanceOf(Resource.Error::class.java)
//            Truth.assertThat(resource.error).isNotNull()
//            Truth.assertThat(resource.error).isInstanceOf(UiText.StringResource::class.java)
//            Truth.assertThat((resource.error as UiText.StringResource).resId)
//                .isEqualTo(R.string.something_went_wrong_error_message)
//        }
//
//}