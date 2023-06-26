package com.example.movies.core.network.mapper.search.movie

import com.example.movies.core.model.search.movie.Movie
import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.mapper.base.RemoteResponseModelMapper
import com.example.movies.core.network.model.ImageSizes
import com.example.movies.core.network.model.search.movie.MovieDTO
import javax.inject.Inject

class MovieMapper @Inject constructor() : RemoteResponseModelMapper<MovieDTO, Movie> {
    override fun mapFromModel(model: MovieDTO): Movie {
        return Movie(
            id = model.id,
            title = model.title,
            poster = model.posterPath?.let {
                "${BuildConfig.BASE_IMAGE_URL}/${ImageSizes.ORIGINAL.size}${model.posterPath}"
            }
        )
    }
}