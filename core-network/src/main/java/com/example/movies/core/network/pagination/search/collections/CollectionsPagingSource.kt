package com.example.movies.core.network.pagination.search.collections

import com.example.movies.core.network.datasource.abstraction.search.SearchRemoteDataSource
import com.example.movies.core.network.model.search.collection.CollectionDTO
import com.example.movies.core.network.pagination.base.BasePagingSource

class CollectionsPagingSource constructor(
    private val remoteDataSource: SearchRemoteDataSource,
    private val query: String?
) : BasePagingSource<CollectionDTO>() {
    override suspend fun apiFunc(page: Int): List<CollectionDTO> {
        return remoteDataSource.fetchCollections(page, query = query)
    }
}