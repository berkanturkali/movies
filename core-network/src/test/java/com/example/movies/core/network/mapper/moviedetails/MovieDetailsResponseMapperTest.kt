package com.example.movies.core.network.mapper.moviedetails

import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.mapper.poster.ImagePathMapper
import com.example.movies.core.network.model.ImageSizes
import com.example.movies.core.network.utils.DummyData
import com.google.common.truth.Truth
import org.junit.Test

class MovieDetailsResponseMapperTest {


    private val imageMapper = ImagePathMapper()
    private val responseMapper = MovieDetailsResponseMapper(imageMapper)


    @Test
    fun `check that mapFromModel maps data correctly`() {
        val dto = DummyData.movieDetailsResponseDTO
        val model = responseMapper.mapFromModel(dto)
        Truth.assertThat(model.title)
            .isEqualTo("${dto.title} (2023)")
        Truth.assertThat(model.image)
            .isEqualTo("${BuildConfig.BASE_IMAGE_URL}/${ImageSizes.ORIGINAL.size}${dto.posterPath}")
        Truth.assertThat(model.releaseDate)
            .isEqualTo(dto.releaseDate)
        Truth.assertThat(model.tagLine)
            .isEqualTo(dto.tagline)
        Truth.assertThat(model.genres)
            .isEqualTo(listOf("Action", "Adventure"))
        Truth.assertThat(model.score)
            .isEqualTo(0.86f)
        Truth.assertThat(model.languages)
            .isEqualTo(listOf("EN"))
        Truth.assertThat(model.status)
            .isEqualTo("R")
        Truth.assertThat(model.overview).isEqualTo(dto.overview)
        Truth.assertThat(model.revenue).isEqualTo("\$512,609,552.00")
    }
}