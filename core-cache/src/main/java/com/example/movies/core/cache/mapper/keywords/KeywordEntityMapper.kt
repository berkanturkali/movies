package com.example.movies.core.cache.mapper.keywords

import com.example.movies.core.cache.mapper.base.EntityModelMapper
import com.example.movies.core.cache.model.KeywordEntity
import com.example.movies.core.model.search.keyword.Keyword
import javax.inject.Inject

class KeywordEntityMapper @Inject constructor() : EntityModelMapper<KeywordEntity, Keyword> {
    override fun mapFromEntity(entity: KeywordEntity): Keyword {
        return Keyword(
            id = entity.id,
            name = entity.name
        )
    }
}