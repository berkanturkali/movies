package com.example.movies.core.network.pagination.search.movies

import com.example.movies.core.network.datasource.abstraction.search.SearchRemoteDataSource
import com.example.movies.core.network.model.search.movie.MovieDTO
import com.example.movies.core.network.pagination.base.BasePagingSource

class MoviesPagingSource constructor(
    private val searchRemoteDataSource: SearchRemoteDataSource,
    private val query: String?
) : BasePagingSource<MovieDTO>() {
    override suspend fun apiFunc(page: Int): List<MovieDTO> {
        return searchRemoteDataSource.fetchMovies(page, query)
    }
}