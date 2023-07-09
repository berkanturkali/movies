package com.example.movies.core.cache.datasource.implementation.favorites

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.movies.core.cache.dao.FavoritesDao
import com.example.movies.core.cache.datasource.abstraction.favorites.FavoritesCacheDataSource
import com.example.movies.core.cache.db.favorites.FavoritesDatabase
import com.example.movies.core.cache.factory.InMemoryDatabaseFactory
import com.example.movies.core.cache.model.favorites.MovieEntity
import com.example.movies.core.cache.utils.DummyData
import com.google.common.truth.Truth
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@[RunWith(AndroidJUnit4::class) SmallTest]
class FavoritesCacheDataSourceImplTest {

    private lateinit var db: FavoritesDatabase

    private lateinit var favoritesDao: FavoritesDao

    private lateinit var dataSource: FavoritesCacheDataSource

    @Before
    fun setup() {
        db = InMemoryDatabaseFactory.createInMemoryDatabase()

        favoritesDao = db.favoritesDao

        dataSource = FavoritesCacheDataSourceImpl(favoritesDao)
    }

    @Test
    fun upsert_insertsData_when_dataIsNotInCache() {
        runBlocking {
            val entity = DummyData.movieEntity
            val entities = dataSource.favorites()
                .first()
            Truth.assertThat(entities)
                .isEmpty()
            dataSource.upsert(entity)
            val newEntities = dataSource.favorites()
                .first()
            Truth.assertThat(newEntities)
                .isNotNull()
            Truth.assertThat(newEntities.size)
                .isEqualTo(1)
            Truth.assertThat(newEntities.first().id)
                .isEqualTo(entity.id)
        }
    }


    @Test
    fun upsert_updatesData_when_dataIsAlreadyInCache() {
        runBlocking {
            val entity = DummyData.movieEntity
            dataSource.upsert(entity)
            val entities = dataSource.favorites()
                .first()
            Truth.assertThat(entities)
                .isNotEmpty()
            val newEntity = entity.copy(name = "Dummy")
            dataSource.upsert(newEntity)
            val newData = dataSource.favorites()
                .first()
            Truth.assertThat(newData)
                .isNotEmpty()
            Truth.assertThat(newData.first().id)
                .isEqualTo(entity.id)
            Truth.assertThat(newData.first().name)
                .isNotEqualTo(entity.name)
        }
    }

    @Test
    fun delete_deletesData_correctly() {
        runBlocking {
            val entity = DummyData.movieEntity
            dataSource.upsert(entity)
            Truth.assertThat(
                dataSource.favorites()
                    .first()
            )
                .isNotEmpty()
            dataSource.delete(entity)
            Truth.assertThat(
                dataSource.favorites()
                    .first()
            )
                .isEmpty()
        }
    }

    @Test
    fun clear_clearsAllData_correctly() {
        runBlocking {
            val entity = DummyData.movieEntity
            val newEntity = MovieEntity(
                id = 2,
                name = "Another Name",
                image = "",
            )
            dataSource.upsert(entity)
            dataSource.upsert(newEntity)
            Truth.assertThat(dataSource.favorites().first().size).isEqualTo(2)
            dataSource.clear()
            Truth.assertThat(dataSource.favorites().first()).isEmpty()
        }
    }


}