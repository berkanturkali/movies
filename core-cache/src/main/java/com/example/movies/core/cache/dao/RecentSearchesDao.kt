package com.example.movies.core.cache.dao

import androidx.room.*
import com.example.movies.core.cache.model.RecentSearchEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface RecentSearchesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecentSearch(recentSearch: RecentSearchEntity): Long
    @Suppress("MaxLineLength")
    @Query(
        "SELECT * FROM recent_searches WHERE text LIKE '%' || :query  ||'%' OR '%' || :query || '%' = '' ORDER BY created_at ASC"
    )
    fun getRecentSearches(query: String): Flow<List<RecentSearchEntity>>

    @Delete
    suspend fun deleteRecentSearch(recentSearch: RecentSearchEntity)

    @Query("DELETE FROM recent_searches")
    suspend fun clearAllRecentSearches()

}