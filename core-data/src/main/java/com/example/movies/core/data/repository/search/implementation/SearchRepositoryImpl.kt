package com.example.movies.core.data.repository.search.implementation

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.movies.core.cache.datasource.abstraction.RecentSearchesCacheDataSource
import com.example.movies.core.cache.mapper.recent_searches.RecentSearchEntityMapper
import com.example.movies.core.cache.model.RecentSearchEntity
import com.example.movies.core.data.repository.search.abstraction.SearchRepository
import com.example.movies.core.model.search.collection.Collection
import com.example.movies.core.model.search.company.Company
import com.example.movies.core.model.search.keyword.Keyword
import com.example.movies.core.model.search.movie.Movie
import com.example.movies.core.model.search.person.Person
import com.example.movies.core.model.search.recent_search.RecentSearch
import com.example.movies.core.model.search.tv_show.TvShow
import com.example.movies.core.network.datasource.abstraction.search.SearchRemoteDataSource
import com.example.movies.core.network.mapper.search.collection.CollectionMapper
import com.example.movies.core.network.mapper.search.company.CompanyMapper
import com.example.movies.core.network.mapper.search.keyword.KeywordRemoteModelMapper
import com.example.movies.core.network.mapper.search.movie.MovieMapper
import com.example.movies.core.network.mapper.search.person.PersonMapper
import com.example.movies.core.network.mapper.search.tv_show.TvShowMapper
import com.example.movies.core.network.pagination.search.collections.CollectionsPagingSource
import com.example.movies.core.network.pagination.search.companies.CompaniesPagingSource
import com.example.movies.core.network.pagination.search.keywords.KeywordsPagingSource
import com.example.movies.core.network.pagination.search.movies.MoviesPagingSource
import com.example.movies.core.network.pagination.search.people.PeoplePagingSource
import com.example.movies.core.network.pagination.search.tv_shows.TvShowsPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchRemoteDataSource: SearchRemoteDataSource,
    private val recentSearchesCacheDataSource: RecentSearchesCacheDataSource,
    private val companyMapper: CompanyMapper,
    private val collectionMapper: CollectionMapper,
    private val movieMapper: MovieMapper,
    private val personMapper: PersonMapper,
    private val tvShowMapper: TvShowMapper,
    private val recentSearchEntityMapper: RecentSearchEntityMapper,
    private val keywordRemoteModelMapper: KeywordRemoteModelMapper,
) : SearchRepository {
    override suspend fun fetchCompanies(query: String): Flow<PagingData<Company>> {
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
        query: String
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

    override suspend fun fetchKeywords(query: String): Flow<PagingData<Keyword>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = {
                KeywordsPagingSource(
                    remoteDataSource = searchRemoteDataSource,
                    query = query
                )
            }
        ).flow
            .map { pagingData ->
                pagingData.map { dto ->
                    keywordRemoteModelMapper.mapFromModel(dto)
                }
            }
    }

    override suspend fun fetchMovies(query: String): Flow<PagingData<Movie>> {
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

    override suspend fun fetchPeople(query: String): Flow<PagingData<Person>> {
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

    override suspend fun fetchTvShows(query: String): Flow<PagingData<TvShow>> {
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

    override suspend fun insertRecentSearch(recentSearch: String): Long {
        return recentSearchesCacheDataSource.insertRecentSearch(
            RecentSearchEntity(text = recentSearch)
        )
    }

    override fun getRecentSearches(query: String): Flow<List<RecentSearch>> {
        return recentSearchesCacheDataSource.getRecentSearches(query)
            .map { recentSearchesEntities ->
                recentSearchEntityMapper.mapFromEntityList(recentSearchesEntities)
            }
    }

    override suspend fun deleteRecentSearch(recentSearch: String) {
        recentSearchesCacheDataSource.deleteRecentSearch(RecentSearchEntity(recentSearch))
    }

    override suspend fun clearAllRecentSearches() {
        recentSearchesCacheDataSource.clearAllRecentSearches()
    }

}