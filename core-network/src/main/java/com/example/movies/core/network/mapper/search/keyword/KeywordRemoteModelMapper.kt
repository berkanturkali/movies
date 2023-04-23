package com.example.movies.core.network.mapper.search.keyword

import com.example.movies.core.model.search.keyword.Keyword
import com.example.movies.core.network.mapper.base.RemoteResponseModelMapper
import com.example.movies.core.network.model.search.keyword.KeywordDTO
import javax.inject.Inject

class KeywordRemoteModelMapper @Inject constructor() :
    RemoteResponseModelMapper<KeywordDTO, Keyword> {
    override fun mapFromModel(model: KeywordDTO): Keyword {
        return Keyword(
            id = model.id,
            name = model.name
        )
    }
}