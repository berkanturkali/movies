package com.example.movies.core.network.mapper.moviedetails

import com.example.movies.core.network.utils.DummyData
import com.google.common.truth.Truth
import org.junit.Test

class VideoMapperTest {

    private val mapper = VideoMapper()

    @Test
    fun `check that mapFromModel maps data correctly`() {
        val dto = DummyData.videoDTO
        val model = mapper.mapFromModel(dto)
        Truth.assertThat(model.url).isEqualTo("https://www.youtube.com/watch?v=${dto.key}")
    }
}