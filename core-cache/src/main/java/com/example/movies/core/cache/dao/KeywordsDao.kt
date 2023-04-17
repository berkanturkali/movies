package com.example.movies.core.cache.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movies.core.cache.model.KeywordEntity

@Dao
interface KeywordsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(keywords: List<KeywordEntity>)

    @Query("SELECT * FROM keywords WHERE name LIKE :query")
    fun getKeywords(query: String?): PagingSource<Int, KeywordEntity>

    @Query("DELETE  from keywords")
    suspend fun clearAll()
}