package com.example.movies.core.network.mapper.upcoming

import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.model.ImageSizes
import com.example.movies.core.network.utils.DummyData
import com.google.common.truth.Truth
import org.junit.Test

class UpcomingMovieMapperTest {


    private val mapper = UpcomingMovieMapper()

    @Test
    fun `check that map from model maps model correctly`() {
        val model = DummyData.upcomingMovieDTO
        val uiModel = mapper.mapFromModel(model)
        Truth.assertThat(uiModel.id).isEqualTo(model.id)
        Truth.assertThat(uiModel.description).isEqualTo(model.overview)
        Truth.assertThat(uiModel.title).isEqualTo(model.title)
        if (model.posterPath != null) {
            Truth.assertThat(uiModel.image)
                .isEqualTo("${BuildConfig.BASE_IMAGE_URL}${ImageSizes.ORIGINAL}${model.posterPath}")
        } else {
            Truth.assertThat(uiModel.image).isNull()
        }
    }
}