package com.example.movies.core.network.mapper.search.collection

import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.model.ImageSizes
import com.example.movies.core.network.utils.DummyData
import com.google.common.truth.Truth
import org.junit.Test

class CollectionMapperTest {

    private val mapper = CollectionMapper()

    @Test
    fun `check that mapFromModel maps data correctly`(){
        val collectionDto = DummyData.collectionDTO
        val model = mapper.mapFromModel(collectionDto)
        Truth.assertThat(collectionDto.id).isEqualTo(model.id)
        Truth.assertThat(model.poster).isEqualTo("${BuildConfig.BASE_IMAGE_URL}/${ImageSizes.ORIGINAL}${collectionDto.posterPath}")
        Truth.assertThat(collectionDto.name).isEqualTo(model.name)
    }
}