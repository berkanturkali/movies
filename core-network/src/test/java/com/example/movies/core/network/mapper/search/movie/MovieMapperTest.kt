package com.example.movies.core.network.mapper.search.movie

import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.model.ImageSizes
import com.example.movies.core.network.utils.DummyData
import com.google.common.truth.Truth
import org.junit.Test

class MovieMapperTest {

    private val mapper = MovieMapper()

    @Test
    fun `check that mapFromModel maps data correctly`() {
        val dto = DummyData.movieDTO
        val model = mapper.mapFromModel(dto)
        Truth.assertThat(dto.id)
            .isEqualTo(model.id)
        Truth.assertThat(model.poster)
            .isEqualTo("${BuildConfig.BASE_IMAGE_URL}/${ImageSizes.ORIGINAL}${dto.posterPath}")
        Truth.assertThat(dto.title)
            .isEqualTo(model.title)
    }
}