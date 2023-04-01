package com.example.movies.core.data.repository.search.implementation

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.movies.core.data.repository.search.abstraction.SearchRepository
import com.example.movies.core.model.search.company.Company
import com.example.movies.core.network.datasource.abstraction.search.SearchRemoteDataSource
import com.example.movies.core.network.model.search.collection.CollectionDTO
import com.example.movies.core.network.model.search.keyword.KeywordDTO
import com.example.movies.core.network.model.search.movie.MovieDTO
import com.example.movies.core.network.model.search.people.PersonDTO
import com.example.movies.core.network.model.search.tvshow.TvShowDTO
import com.example.movies.core.network.pagination.search.companies.CompaniesPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchRemoteDataSource: SearchRemoteDataSource
) : SearchRepository {
    override suspend fun fetchCompanies(page: Int, query: String?): Flow<PagingData<Company>> {
        TODO("Not yet implemented")
//        return Pager(
//            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
//            pagingSourceFactory = {
//                CompaniesPagingSource(
//                    remoteDataSource = searchRemoteDataSource,
//                    query = query
//                )
//            }.asFlow()
//        )
    }

    override suspend fun fetchCollections(
        page: Int,
        query: String?
    ): Flow<PagingData<CollectionDTO>> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchKeywords(page: Int, query: String?): Flow<PagingData<KeywordDTO>> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchMovies(page: Int, query: String?): Flow<PagingData<MovieDTO>> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchPeople(page: Int, query: String?): Flow<PagingData<PersonDTO>> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchTvShow(page: Int, query: String?): Flow<PagingData<TvShowDTO>> {
        TODO("Not yet implemented")
    }

}