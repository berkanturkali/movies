package com.example.movies.core.data.repository.movies.abstraction

import com.example.movies.core.common.Resource
import com.example.movies.core.model.movie_details.Movie
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    suspend fun fetchMovie(id: Int): Flow<Resource<Movie>>
}