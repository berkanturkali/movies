package com.example.movies.core.cache.datasource.implementation

import com.example.movies.core.cache.dao.RecentSearchesDao
import com.example.movies.core.cache.datasource.abstraction.RecentSearchesCacheDataSource
import com.example.movies.core.cache.model.RecentSearchEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RecentSearchesCacheDataSourceImpl @Inject constructor(
    private val recentSearchesDao: RecentSearchesDao,
) : RecentSearchesCacheDataSource {
    override suspend fun insertRecentSearch(recentSearch: RecentSearchEntity): Long {
        return recentSearchesDao.insertRecentSearch(recentSearch)
    }

    override fun getRecentSearches(query: String): Flow<List<RecentSearchEntity>> {
        return recentSearchesDao.getRecentSearches(query)
    }

    override suspend fun deleteRecentSearch(recentSearch: RecentSearchEntity) {
        recentSearchesDao.deleteRecentSearch(recentSearch)
    }

    override suspend fun clearAllRecentSearches() {
        recentSearchesDao.clearAllRecentSearches()
    }
}