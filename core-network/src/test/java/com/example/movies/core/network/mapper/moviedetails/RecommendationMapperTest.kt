package com.example.movies.core.network.mapper.moviedetails

import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.mapper.ScoreMapper
import com.example.movies.core.network.mapper.poster.ImagePathMapper
import com.example.movies.core.network.model.ImageSizes
import com.example.movies.core.network.utils.DummyData
import com.google.common.truth.Truth
import org.junit.Test

class RecommendationMapperTest {

    private val imagePathMapper = ImagePathMapper()

    private val scoreMapper = ScoreMapper()

    private val mapper =
        RecommendationMapper(imagePathMapper = imagePathMapper, scoreMapper = scoreMapper)

    @Test
    fun `check that mapFromModel maps data correctly`() {
        val dto = DummyData.recommendationDTO
        val model = mapper.mapFromModel(dto)
        Truth.assertThat(model.id)
            .isEqualTo(dto.id)
        Truth.assertThat(model.name)
            .isEqualTo(dto.title)
        Truth.assertThat(model.image)
            .isEqualTo("${BuildConfig.BASE_IMAGE_URL}/${ImageSizes.ORIGINAL.size}${dto.posterPath}")
        Truth.assertThat(model.score)
            .isEqualTo(0.6f)
    }
}