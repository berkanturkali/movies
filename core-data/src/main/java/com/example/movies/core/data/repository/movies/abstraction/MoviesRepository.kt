package com.example.movies.core.data.repository.movies.abstraction

import androidx.paging.PagingData
import com.example.movies.core.common.Resource
import com.example.movies.core.model.moviedetails.Cast
import com.example.movies.core.model.moviedetails.Movie
import com.example.movies.core.model.moviedetails.Review
import com.example.movies.core.model.moviedetails.Reviews
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    suspend fun fetchMovie(id: Int): Flow<Resource<Movie>>

    suspend fun fetchCast(id: Int): Flow<Resource<List<Cast?>>>

    suspend fun fetchReviews(id: Int): Flow<Resource<Reviews>>
}