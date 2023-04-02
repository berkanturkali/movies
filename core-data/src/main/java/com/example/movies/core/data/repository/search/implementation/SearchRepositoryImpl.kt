package com.example.movies.core.data.repository.search.implementation

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.movies.core.data.repository.search.abstraction.SearchRepository
import com.example.movies.core.model.search.collection.Collection
import com.example.movies.core.model.search.company.Company
import com.example.movies.core.model.search.movie.Movie
import com.example.movies.core.model.search.person.Person
import com.example.movies.core.network.datasource.abstraction.search.SearchRemoteDataSource
import com.example.movies.core.network.mapper.search.collection.CollectionMapper
import com.example.movies.core.network.mapper.search.company.CompanyMapper
import com.example.movies.core.network.mapper.search.movie.MovieMapper
import com.example.movies.core.network.mapper.search.person.PersonMapper
import com.example.movies.core.network.model.search.keyword.KeywordDTO
import com.example.movies.core.network.model.search.people.PersonDTO
import com.example.movies.core.network.model.search.tvshow.TvShowDTO
import com.example.movies.core.network.pagination.search.collections.CollectionsPagingSource
import com.example.movies.core.network.pagination.search.companies.CompaniesPagingSource
import com.example.movies.core.network.pagination.search.movies.MoviesPagingSource
import com.example.movies.core.network.pagination.search.people.PeoplePagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchRemoteDataSource: SearchRemoteDataSource,
    private val companyMapper: CompanyMapper,
    private val collectionMapper: CollectionMapper,
    private val movieMapper: MovieMapper,
    private val personMapper: PersonMapper,
) : SearchRepository {
    override suspend fun fetchCompanies(page: Int, query: String?): Flow<PagingData<Company>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = {
                CompaniesPagingSource(
                    remoteDataSource = searchRemoteDataSource,
                    query = query
                )
            }
        ).flow
            .map { pagingData ->
                pagingData.map { dto ->
                    companyMapper.mapFromModel(dto)
                }
            }
    }

    override suspend fun fetchCollections(
        page: Int,
        query: String?
    ): Flow<PagingData<Collection>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = {
                CollectionsPagingSource(
                    remoteDataSource = searchRemoteDataSource,
                    query = query
                )
            }
        ).flow
            .map { pagingData ->
                pagingData.map { dto ->
                    collectionMapper.mapFromModel(dto)
                }
            }
    }

    override suspend fun fetchKeywords(page: Int, query: String?): Flow<PagingData<KeywordDTO>> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchMovies(page: Int, query: String?): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = {
                MoviesPagingSource(
                    searchRemoteDataSource = searchRemoteDataSource,
                    query = query
                )
            }
        ).flow
            .map { pagingData ->
                pagingData.map { dto ->
                    movieMapper.mapFromModel(dto)
                }
            }
    }

    override suspend fun fetchPeople(page: Int, query: String?): Flow<PagingData<Person>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = {
                PeoplePagingSource(
                    searchRemoteDataSource = searchRemoteDataSource,
                    query = query
                )
            }
        ).flow
            .map { pagingData ->
                pagingData.map { dto ->
                    personMapper.mapFromModel(dto)
                }
            }
    }

    override suspend fun fetchTvShow(page: Int, query: String?): Flow<PagingData<TvShowDTO>> {
        TODO("Not yet implemented")
    }

}