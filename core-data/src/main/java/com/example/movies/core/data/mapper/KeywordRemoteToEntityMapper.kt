package com.example.movies.core.data.mapper

import com.example.movies.core.cache.model.KeywordEntity
import com.example.movies.core.data.mapper.base.BaseRemoteToEntityMapper
import com.example.movies.core.network.model.search.keyword.KeywordDTO
import javax.inject.Inject

class KeywordRemoteToEntityMapper @Inject constructor() :
    BaseRemoteToEntityMapper<KeywordDTO, KeywordEntity> {
    override fun mapFromModel(model: KeywordDTO): KeywordEntity {
        return KeywordEntity(
            id = model.id,
            name = model.name
        )
    }
}