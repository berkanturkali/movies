package com.example.movies.core.network.mapper.search.collection

import com.example.movies.core.model.search.collection.Collection
import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.mapper.base.RemoteResponseModelMapper
import com.example.movies.core.network.model.ImageSizes
import com.example.movies.core.network.model.search.collection.CollectionDTO
import javax.inject.Inject

class CollectionMapper @Inject constructor() :
    RemoteResponseModelMapper<CollectionDTO, Collection> {
    override fun mapFromModel(model: CollectionDTO): Collection {
        return Collection(
            id = model.id,
            name = model.name,
            poster = model.posterPath?.let { "${BuildConfig.BASE_IMAGE_URL}/${ImageSizes.ORIGINAL}${model.posterPath}" }
        )
    }
}