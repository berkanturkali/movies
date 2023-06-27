package com.example.movies.core.network.mapper.review

import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.mapper.poster.ImagePathMapper
import com.example.movies.core.network.model.ImageSizes
import com.example.movies.core.network.utils.DummyData
import com.google.common.truth.Truth
import org.junit.Test

class ReviewMapperTest {

    private val imagePathMapper = ImagePathMapper()

    private val mapper = ReviewMapper(imagePathMapper)

    @Test
    fun `check that mapFromModel maps data correctly`() {
        val dto = DummyData.reviewDTO
        val model = mapper.mapFromModel(dto)
        Truth.assertThat(model.review)
            .isEqualTo(dto.content)
        Truth.assertThat(model.reviewerName)
            .isEqualTo(dto.author)
        Truth.assertThat(model.rating)
            .isEqualTo("8.0")
        Truth.assertThat(model.reviewerImage)
            .isEqualTo(
                "${BuildConfig.BASE_IMAGE_URL}/${ImageSizes.ORIGINAL.size}${dto.authorDetails?.avatarPath}"
            )
        Truth.assertThat(model.reviewDate).isEqualTo("2023-05-31 14:58")
    }
}