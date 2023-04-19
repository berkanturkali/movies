package com.example.movies.core.cache.datasource.implementation

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.movies.core.cache.dao.RecentSearchesDao
import com.example.movies.core.cache.datasource.abstraction.RecentSearchesCacheDataSource
import com.example.movies.core.cache.db.recentsearches.RecentSearchesDatabase
import com.example.movies.core.cache.model.RecentSearchEntity
import com.google.common.truth.Truth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch

@RunWith(AndroidJUnit4::class)
@SmallTest
class RecentSearchesCacheDataSourceImplTest {

    private lateinit var database: RecentSearchesDatabase

    private lateinit var recentSearchesDao: RecentSearchesDao

    private lateinit var dataSource: RecentSearchesCacheDataSource

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            RecentSearchesDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()

        recentSearchesDao = database.recentSearchesDao

        dataSource = RecentSearchesCacheDataSourceImpl(recentSearchesDao)
    }

    @Test
    fun insertRecentSearch_insertsDataAsExpected() = runBlocking {
        val recentSearchEntity = RecentSearchEntity(
            text = "Recent Search"
        )
        dataSource.insertRecentSearch(recentSearchEntity)

        val latch = CountDownLatch(1)
        val job = async(Dispatchers.IO) {
            dataSource.getRecentSearches("")
                .collect { recentSearches ->
                    Truth.assertThat(recentSearches)
                        .contains(recentSearchEntity)
                    latch.countDown()
                }
        }

        latch.await()
        job.cancelAndJoin()
    }

    @Test
    fun clearAllRecentSearches_clearsDbDataAsExpected() = runBlocking {
        val firstRecentSearch = RecentSearchEntity("First")
        val secondRecentSearch = RecentSearchEntity("Second")

        dataSource.insertRecentSearch(firstRecentSearch)
        dataSource.insertRecentSearch(secondRecentSearch)

        dataSource.clearAllRecentSearches()

        val latch = CountDownLatch(1)
        val job = async(Dispatchers.IO) {
            dataSource.getRecentSearches("")
                .collect { recentSearches ->
                    Truth.assertThat(recentSearches)
                        .doesNotContain(firstRecentSearch)
                    latch.countDown()
                }
        }

        latch.await()
        job.cancelAndJoin()
    }

    @Test
    fun deleteRecentSearch_deletesDataAsExpected() = runBlocking {
        val recentSearchEntity = RecentSearchEntity("Recent Search")
        dataSource.insertRecentSearch(recentSearchEntity)

        val recentSearches = dataSource.getRecentSearches("")
            .first()
        Truth.assertThat(recentSearches)
            .contains(recentSearchEntity)
        dataSource.deleteRecentSearch(recentSearchEntity)
        val newRecentSearches = dataSource.getRecentSearches("")
            .first()
        Truth.assertThat(newRecentSearches).isEmpty()
    }

    @After
    fun tearDown() {
        database.close()
    }
}