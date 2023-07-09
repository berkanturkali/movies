package com.example.movies.feature.details.movie.usecases

import com.example.movies.core.data.repository.favorites.abstraction.FavoritesRepository
import javax.inject.Inject

class CheckIfTheMovieIsInFavoritesUseCase @Inject constructor(
    private val favoritesRepo: FavoritesRepository
) {

    suspend operator fun invoke(id: Int): Boolean {
        return favoritesRepo.getMovie(id) != null
    }
}