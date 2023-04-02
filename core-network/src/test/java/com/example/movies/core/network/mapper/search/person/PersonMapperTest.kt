package com.example.movies.core.network.mapper.search.person

import com.example.movies.core.network.mapper.poster.ImagePathMapper
import com.example.movies.core.network.utils.DummyData
import com.google.common.truth.Truth
import org.junit.Test

class PersonMapperTest {

    private val imagePathMapper = ImagePathMapper()

    private val modelMapper = PersonMapper(imagePathMapper)

    @Test
    fun `check that mapFromModel maps data correctly`() {
        val model = DummyData.personDTO
        val mappedModel = modelMapper.mapFromModel(model)
        Truth.assertThat(model.id)
            .isEqualTo(mappedModel.id)
        Truth.assertThat(model.name)
            .isEqualTo(mappedModel.name)
        Truth.assertThat(imagePathMapper.mapPath(model.profilePath))
            .isEqualTo(mappedModel.path)
    }


}