package com.example.movies.feature.details.movie.usecases

import com.example.movies.core.common.Resource
import com.example.movies.core.data.repository.movies.abstraction.MoviesRepository
import com.example.movies.core.model.moviedetails.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchMovieUseCase @Inject constructor(
    private val repo: MoviesRepository
) {
    suspend operator fun invoke(id: Int): Flow<Resource<Movie>> {
        return repo.fetchMovie(id)
    }

}