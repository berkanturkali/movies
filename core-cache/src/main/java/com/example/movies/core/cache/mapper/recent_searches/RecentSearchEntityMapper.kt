package com.example.movies.core.cache.mapper.recent_searches

import com.example.movies.core.cache.mapper.base.EntityModelMapper
import com.example.movies.core.cache.model.RecentSearchEntity
import com.example.movies.core.model.search.recent_search.RecentSearch
import javax.inject.Inject

class RecentSearchEntityMapper @Inject constructor() :
    EntityModelMapper<RecentSearchEntity, RecentSearch> {
    override fun mapFromEntity(entity: RecentSearchEntity): RecentSearch {
        return RecentSearch(
            text = entity.text
        )
    }
}