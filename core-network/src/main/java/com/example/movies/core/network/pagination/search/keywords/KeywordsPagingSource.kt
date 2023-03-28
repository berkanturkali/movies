package com.example.movies.core.network.pagination.search.keywords

import com.example.movies.core.network.datasource.abstraction.search.SearchRemoteDataSource
import com.example.movies.core.network.model.search.keyword.KeywordDTO
import com.example.movies.core.network.pagination.base.BasePagingSource

class KeywordsPagingSource constructor(
    private val remoteDataSource: SearchRemoteDataSource,
    private val query: String?
) : BasePagingSource<KeywordDTO>() {
    override suspend fun apiFunc(page: Int): List<KeywordDTO> {
        return remoteDataSource.fetchKeywords(page, query)
    }
}