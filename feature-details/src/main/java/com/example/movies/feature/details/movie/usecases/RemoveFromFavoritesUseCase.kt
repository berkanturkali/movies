package com.example.movies.feature.details.movie.usecases

import com.example.movies.core.data.repository.favorites.abstraction.FavoritesRepository
import com.example.movies.core.model.moviedetails.Movie
import javax.inject.Inject

class RemoveFromFavoritesUseCase @Inject constructor(
    private val favoritesRepository: FavoritesRepository
) {
    suspend operator fun invoke(movie: Movie) {
        favoritesRepository.delete(movie)
    }
}