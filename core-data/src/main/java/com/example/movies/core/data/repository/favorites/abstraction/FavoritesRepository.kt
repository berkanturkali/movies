package com.example.movies.core.data.repository.favorites.abstraction

import com.example.movies.core.model.moviedetails.Movie
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {

    suspend fun upsert(movie: Movie): Long

    fun favorites(): Flow<List<Movie>>

    suspend fun getMovie(id: Int): Movie?

    suspend fun delete(movie: Movie)

    suspend fun clear()

}