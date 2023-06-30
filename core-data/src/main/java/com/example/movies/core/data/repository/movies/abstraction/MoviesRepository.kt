package com.example.movies.core.data.repository.movies.abstraction

import com.example.movies.core.common.Resource
import com.example.movies.core.model.moviedetails.*
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {

    suspend fun fetchMovie(id: Int): Flow<Resource<Movie>>

    suspend fun fetchCast(id: Int): Flow<Resource<List<Cast?>>>

    suspend fun fetchReviews(id: Int): Flow<Resource<Reviews>>

    suspend fun fetchKeywords(id: Int): Flow<Resource<List<Keyword>>>

    suspend fun fetchVideos(id: Int): Flow<Resource<List<Video>>>

    suspend fun fetchRecommendations(id: Int): Flow<Resource<List<Recommendation>>>
}