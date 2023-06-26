package com.example.movies.core.network.mapper.search.tvshow

import com.example.movies.core.network.mapper.poster.ImagePathMapper
import com.example.movies.core.network.utils.DummyData
import com.google.common.truth.Truth
import org.junit.Test

class TvShowMapperTest {

    private val imagePathMapper = ImagePathMapper()

    private val modelMapper = TvShowMapper(imagePathMapper)

    @Test
    fun `check that mapFromModel maps data correctly`() {
        val model = DummyData.tvShowDTO
        val mappedModel = modelMapper.mapFromModel(model)
        Truth.assertThat(model.id)
            .isEqualTo(mappedModel.id)
        Truth.assertThat(model.name)
            .isEqualTo(mappedModel.name)
        Truth.assertThat(imagePathMapper.mapPath(model.posterPath))
            .isEqualTo(mappedModel.poster)
    }
}