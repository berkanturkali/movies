package com.example.movies.core.network.mapper.moviedetails

import com.example.movies.core.model.moviedetails.Keyword
import com.example.movies.core.network.mapper.base.RemoteResponseModelMapper
import com.example.movies.core.network.model.moviedetails.KeywordDTO
import javax.inject.Inject

class KeywordMapper @Inject constructor(): RemoteResponseModelMapper<KeywordDTO, Keyword> {
    override fun mapFromModel(model: KeywordDTO): Keyword {
        return Keyword(
            name = model.name?.uppercase()
        )
    }
}