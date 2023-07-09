package com.example.movies.core.cache.datasource.abstraction.recentsearches

import com.example.movies.core.cache.model.RecentSearchEntity
import kotlinx.coroutines.flow.Flow

interface RecentSearchesCacheDataSource {

    suspend fun insertRecentSearch(recentSearch: RecentSearchEntity): Long

    fun getRecentSearches(query: String): Flow<List<RecentSearchEntity>>

    suspend fun deleteRecentSearch(recentSearch: RecentSearchEntity)

    suspend fun clearAllRecentSearches()
}