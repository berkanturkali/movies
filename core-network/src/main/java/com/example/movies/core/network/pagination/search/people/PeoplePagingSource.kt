package com.example.movies.core.network.pagination.search.people

import com.example.movies.core.network.datasource.abstraction.search.SearchRemoteDataSource
import com.example.movies.core.network.model.search.people.PersonDTO
import com.example.movies.core.network.pagination.base.BasePagingSource

class PeoplePagingSource constructor(
    private val searchRemoteDataSource: SearchRemoteDataSource,
    private val query: String?
) : BasePagingSource<PersonDTO>() {
    override suspend fun apiFunc(page: Int): List<PersonDTO> {
        return searchRemoteDataSource.fetchPeople(page, query)
    }
}