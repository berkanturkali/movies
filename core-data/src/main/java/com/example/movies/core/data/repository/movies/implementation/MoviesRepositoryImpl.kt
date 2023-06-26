package com.example.movies.core.data.repository.movies.implementation

import com.example.movies.core.common.Resource
import com.example.movies.core.data.repository.movies.abstraction.MoviesRepository
import com.example.movies.core.data.utils.safeApiCall
import com.example.movies.core.model.moviedetails.Movie
import com.example.movies.core.network.datasource.abstraction.movies.MoviesRemoteDataSource
import com.example.movies.core.network.mapper.moviedetails.MovieDetailsResponseMapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val remoteDataSource: MoviesRemoteDataSource,
    private val movieDetailsResponseMapper: MovieDetailsResponseMapper,
) : MoviesRepository {

    override suspend fun fetchMovie(id: Int): Flow<Resource<Movie>> {
        return safeApiCall(mapFromModel = movieDetailsResponseMapper::mapFromModel) {
            remoteDataSource.fetchMovie(id)
        }
    }
}