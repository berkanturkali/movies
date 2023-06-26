package com.example.movies.core.network.mapper.moviedetails

import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.mapper.poster.ImagePathMapper
import com.example.movies.core.network.model.ImageSizes
import com.example.movies.core.network.utils.DummyData
import com.google.common.truth.Truth
import org.junit.Test

class CastResponseMapperTest {

    private val imageMapper = ImagePathMapper()

    private val castMapper = CastResponseMapper(imageMapper)

    @Test
    fun `check that mapFromModel maps data correctly`() {
        val dto = DummyData.castDTO
        val model = castMapper.mapFromModel(dto)
        Truth.assertThat(model.image)
            .isEqualTo(
                "${BuildConfig.BASE_IMAGE_URL}/${ImageSizes.ORIGINAL.size}${dto.profilePath}"
            )
        Truth.assertThat(model.name)
            .isEqualTo(dto.name)
        Truth.assertThat(model.characterName)
            .isEqualTo(dto.character)
    }
}