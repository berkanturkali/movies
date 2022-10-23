package com.example.movies.core.network.mapper.nowplaying

import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.model.ImageSizes
import com.example.movies.core.network.utils.DummyData
import com.google.common.truth.Truth
import org.junit.Test

class NowPlayingMoviesResponseMapperTest {


    private val mapper = NowPlayingMoviesResponseMapper()

    @Test
    fun `check that mapFromModel maps data correctly`() {
        val model = DummyData.nowPlayingDTO
        val nowPlayingMovie = mapper.mapFromModel(model)
        Truth.assertThat(nowPlayingMovie.id).isEqualTo(model.id)
        Truth.assertThat(nowPlayingMovie.description).isEqualTo(model.overview)
        Truth.assertThat(nowPlayingMovie.title).isEqualTo(model.title)
        Truth.assertThat(nowPlayingMovie.image)
            .isEqualTo("${BuildConfig.BASE_IMAGE_URL}${ImageSizes.ORIGINAL}${model.posterPath}")
    }
}