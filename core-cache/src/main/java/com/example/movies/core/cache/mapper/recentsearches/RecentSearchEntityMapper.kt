package com.example.movies.core.cache.mapper.recentsearches

import com.example.movies.core.cache.mapper.base.EntityModelMapper
import com.example.movies.core.cache.model.RecentSearchEntity
import com.example.movies.core.model.search.recentsearch.RecentSearch
import javax.inject.Inject

class RecentSearchEntityMapper @Inject constructor() :
    EntityModelMapper<RecentSearchEntity, RecentSearch> {
    override fun mapFromEntity(entity: RecentSearchEntity): RecentSearch {
        return RecentSearch(
            text = entity.text
        )
    }
}