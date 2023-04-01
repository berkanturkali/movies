package com.example.movies.core.network.mapper.search.company

import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.model.ImageSizes
import com.example.movies.core.network.utils.DummyData
import com.google.common.truth.Truth
import org.junit.Test

class CompanyMapperTest {

    private val mapper = CompanyMapper()

    @Test
    fun `check that mapFromModel maps data correctly`() {
        val dtoModel = DummyData.companyDTO
        val model = mapper.mapFromModel(dtoModel)
        Truth.assertThat(dtoModel.id).isEqualTo(model.id)
        Truth.assertThat(model.logo).isEqualTo("${BuildConfig.BASE_IMAGE_URL}/${ImageSizes.ORIGINAL}${dtoModel.logoPath}")
        Truth.assertThat(dtoModel.name).isEqualTo(model.name)
    }
}