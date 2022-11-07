package com.example.movies.core.data.repository.upcoming.abstraction

import com.example.movies.core.common.Resource
import com.example.movies.core.model.home.UpcomingMovie
import kotlinx.coroutines.flow.Flow

interface UpcomingRepository {

    suspend fun fetchUpcomingMovies(): Flow<Resource<UpcomingMovie>>
}