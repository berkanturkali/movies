package com.example.movies.core.data.repository.search.implementation

import androidx.paging.*
import com.example.movies.core.cache.dao.KeywordsDao
import com.example.movies.core.cache.dao.RemoteKeyDao
import com.example.movies.core.cache.db.keywords.KeywordsDatabase
import com.example.movies.core.cache.mapper.keywords.KeywordEntityMapper
import com.example.movies.core.data.mapper.KeywordRemoteToEntityMapper
import com.example.movies.core.data.mediator.KeywordsRemoteMediator
import com.example.movies.core.data.repository.search.abstraction.SearchRepository
import com.example.movies.core.model.search.collection.Collection
import com.example.movies.core.model.search.company.Company
import com.example.movies.core.model.search.keyword.Keyword
import com.example.movies.core.model.search.movie.Movie
import com.example.movies.core.model.search.person.Person
import com.example.movies.core.model.search.tv_show.TvShow
import com.example.movies.core.network.datasource.abstraction.search.SearchRemoteDataSource
import com.example.movies.core.network.mapper.search.collection.CollectionMapper
import com.example.movies.core.network.mapper.search.company.CompanyMapper
import com.example.movies.core.network.mapper.search.movie.MovieMapper
import com.example.movies.core.network.mapper.search.person.PersonMapper
import com.example.movies.core.network.mapper.search.tv_show.TvShowMapper
import com.example.movies.core.network.pagination.search.collections.CollectionsPagingSource
import com.example.movies.core.network.pagination.search.companies.CompaniesPagingSource
import com.example.movies.core.network.pagination.search.movies.MoviesPagingSource
import com.example.movies.core.network.pagination.search.people.PeoplePagingSource
import com.example.movies.core.network.pagination.search.tv_shows.TvShowsPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchRemoteDataSource: SearchRemoteDataSource,
    private val keywordsDatabase: KeywordsDatabase,
    private val keywordsDao: KeywordsDao,
    private val remoteKeyDao: RemoteKeyDao,
    private val companyMapper: CompanyMapper,
    private val collectionMapper: CollectionMapper,
    private val movieMapper: MovieMapper,
    private val personMapper: PersonMapper,
    private val tvShowMapper: TvShowMapper,
    private val keywordRemoteToEntityMapper: KeywordRemoteToEntityMapper,
    private val keywordEntityMapper: KeywordEntityMapper,
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

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun fetchKeywords(query: String?): Flow<PagingData<Keyword>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                prefetchDistance = 10,
                initialLoadSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                keywordsDao.getKeywords(query)
            },
            remoteMediator = KeywordsRemoteMediator(
                query = query,
                keywordMapper = keywordRemoteToEntityMapper,
                keywordsDao = keywordsDao,
                remoteKeyDao = remoteKeyDao,
                keywordsDatabase = keywordsDatabase,
                remoteDataSource = searchRemoteDataSource,
            )
        ).flow
            .map { pagingData ->
                pagingData.map { entity ->
                    keywordEntityMapper.mapFromEntity(entity)
                }
            }
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

    override suspend fun fetchTvShows(page: Int, query: String?): Flow<PagingData<TvShow>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = {
                TvShowsPagingSource(
                    searchRemoteDataSource = searchRemoteDataSource,
                    query = query
                )
            }
        ).flow
            .map { pagingData ->
                pagingData.map { dto ->
                    tvShowMapper.mapFromModel(dto)
                }
            }
    }

}