package com.example.movies.core.network.mapper.moviedetails

import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.mapper.poster.ImagePathMapper
import com.example.movies.core.network.model.ImageSizes
import com.example.movies.core.network.utils.DummyData
import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CastResponseMapperTest {

    private val imageMapper = ImagePathMapper()

    private val castMapper = CastResponseMapper(imageMapper)

    @Test
    fun `check that mapFromModel maps data correctly`() {
        val dto = DummyData.castDTO
        val model = castMapper.mapFromModel(dto)
        assertThat(model.image)
            .isEqualTo(
                "${BuildConfig.BASE_IMAGE_URL}/${ImageSizes.ORIGINAL.size}${dto.profilePath}"
            )
        assertThat(model.name)
            .isEqualTo(dto.name)
        assertThat(normalizeString(model.characterName))
            .isEqualTo(
                normalizeString("Miles Morales\n" +
                          "Spider-Man\n" +
                          "(voice)"
                )
            )
    }

    private fun normalizeString(input: String?): String? {
        return input?.replace("\\s+".toRegex(), " ")?.trim()
    }
}