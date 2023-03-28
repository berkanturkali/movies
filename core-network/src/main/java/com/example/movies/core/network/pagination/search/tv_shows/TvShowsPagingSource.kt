package com.example.movies.core.network.pagination.search.tv_shows

import com.example.movies.core.network.datasource.abstraction.search.SearchRemoteDataSource
import com.example.movies.core.network.model.search.tvshow.TvShowDTO
import com.example.movies.core.network.pagination.base.BasePagingSource

class TvShowsPagingSource constructor(
    private val searchRemoteDataSource: SearchRemoteDataSource,
    private val query: String?
) : BasePagingSource<TvShowDTO>() {
    override suspend fun apiFunc(page: Int): List<TvShowDTO> {
        return searchRemoteDataSource.fetchTvShow(page, query)
    }
}