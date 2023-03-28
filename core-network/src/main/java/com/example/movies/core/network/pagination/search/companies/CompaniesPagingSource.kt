package com.example.movies.core.network.pagination.search.companies

import com.example.movies.core.network.datasource.abstraction.search.SearchRemoteDataSource
import com.example.movies.core.network.model.search.company.CompanyDTO
import com.example.movies.core.network.pagination.base.BasePagingSource
import javax.inject.Inject

class CompaniesPagingSource constructor(
    private val remoteDataSource: SearchRemoteDataSource,
    private val query: String?
) : BasePagingSource<CompanyDTO>() {
    override suspend fun apiFunc(page: Int): List<CompanyDTO> {
        return remoteDataSource.fetchCompanies(page, query)
    }
}