package com.example.movies.feature.details.movie.usecases

import com.example.movies.core.common.Resource
import com.example.movies.core.data.repository.movies.abstraction.MoviesRepository
import com.example.movies.core.model.moviedetails.Keyword
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchKeywordsUseCase @Inject constructor(
    private val repo: MoviesRepository
) {
    suspend operator fun invoke(id: Int): Flow<Resource<List<Keyword>>> {
        return repo.fetchKeywords(id)
    }
}