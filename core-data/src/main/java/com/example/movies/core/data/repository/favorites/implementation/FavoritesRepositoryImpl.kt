package com.example.movies.core.data.repository.favorites.implementation

import com.example.movies.core.cache.datasource.abstraction.favorites.FavoritesCacheDataSource
import com.example.movies.core.cache.mapper.favorites.MovieEntityMapper
import com.example.movies.core.cache.mapper.favorites.MovieFromEntityMapper
import com.example.movies.core.data.repository.favorites.abstraction.FavoritesRepository
import com.example.movies.core.model.moviedetails.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoritesRepositoryImpl @Inject constructor(
    private val favoritesCacheDataSource: FavoritesCacheDataSource,
    private val movieToEntityMapper: MovieEntityMapper,
    private val movieFromEntityMapper: MovieFromEntityMapper,
) : FavoritesRepository {

    override suspend fun upsert(movie: Movie): Long {
        return favoritesCacheDataSource.upsert(
            movieToEntityMapper.mapToEntity(movie)
        )
    }

    override fun favorites(): Flow<List<Movie>> {
        return favoritesCacheDataSource.favorites()
            .map {
                movieFromEntityMapper.mapFromEntityList(it)
            }
    }

    override suspend fun getMovie(id: Int): Movie? {
        return favoritesCacheDataSource.getMovie(id)
            ?.let {
                movieFromEntityMapper.mapFromEntity(it)
            }
    }

    override suspend fun delete(movie: Movie) {
        favoritesCacheDataSource.delete(movieToEntityMapper.mapToEntity(movie))
    }

    override suspend fun clear() {
        favoritesCacheDataSource.clear()
    }
}