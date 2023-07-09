package com.example.movies.core.cache.datasource.implementation.favorites

import com.example.movies.core.cache.dao.FavoritesDao
import com.example.movies.core.cache.datasource.abstraction.favorites.FavoritesCacheDataSource
import com.example.movies.core.cache.model.favorites.MovieEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoritesCacheDataSourceImpl @Inject constructor(
    private val favoritesDao: FavoritesDao
) : FavoritesCacheDataSource {

    override suspend fun upsert(movie: MovieEntity): Long {
        return favoritesDao.upsert(movie)
    }

    override fun favorites(): Flow<List<MovieEntity>> {
        return favoritesDao.getFavorites()
    }

    override suspend fun getMovie(id: Int): MovieEntity? {
        return favoritesDao.getMovie(id)
    }

    override suspend fun delete(movie: MovieEntity) {
        return favoritesDao.delete(movie)
    }

    override suspend fun clear() {
        return favoritesDao.clear()
    }
}