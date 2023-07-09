package com.example.movies.core.cache.mapper.favorites

import com.example.movies.core.cache.mapper.base.EntityModelMapper
import com.example.movies.core.cache.model.favorites.MovieEntity
import com.example.movies.core.model.moviedetails.Movie
import javax.inject.Inject

class MovieFromEntityMapper @Inject constructor(): EntityModelMapper<MovieEntity, Movie> {
    override fun mapFromEntity(entity: MovieEntity): Movie {
        return Movie(
            id = entity.id,
            title = entity.name,
            image = entity.image
        )
    }
}