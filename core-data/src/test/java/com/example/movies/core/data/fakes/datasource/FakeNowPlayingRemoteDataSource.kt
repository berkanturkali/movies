package com.example.movies.core.data.fakes.datasource

import com.example.movies.core.data.utils.DummyData
import com.example.movies.core.network.datasource.abstraction.nowplaying.NowPlayingRemoteDataSource
import com.example.movies.core.network.model.nowplaying.NowPlayingResponseDTO
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

class FakeNowPlayingRemoteDataSource : NowPlayingRemoteDataSource, BaseFakeDataSource() {
    override suspend fun fetchNowPlayingMovies(): Response<NowPlayingResponseDTO> {
        return if (!throwException) {
            if (returnError) {
                Response.error(
                    errorCode,
                    errorResponse
                        .toResponseBody(
                            "application/json".toMediaTypeOrNull()
                        )
                )
            } else {
                if (successButNull) {
                    Response.success(null)
                } else {
                    Response.success(DummyData.nowPlayingResponseDTO)
                }
            }
        } else {
            throw exception
        }
    }
}