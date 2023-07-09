package com.example.movies.core.cache.mapper.favorites

import com.example.movies.core.cache.mapper.base.ModelToEntityMapper
import com.example.movies.core.cache.model.favorites.MovieEntity
import com.example.movies.core.model.moviedetails.Movie
import javax.inject.Inject

class MovieEntityMapper @Inject constructor() : ModelToEntityMapper<MovieEntity, Movie> {
    override fun mapToEntity(model: Movie): MovieEntity {
        return MovieEntity(
            id = model.id!!,
            name = model.title,
            image = model.image
        )
    }
}