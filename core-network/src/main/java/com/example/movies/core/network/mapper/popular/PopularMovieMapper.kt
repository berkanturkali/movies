package com.example.movies.core.network.mapper.popular

import com.example.movies.core.model.home.PopularMovie
import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.mapper.base.RemoteResponseModelMapper
import com.example.movies.core.network.model.ImageSizes
import com.example.movies.core.network.model.popular.PopularMovieDTO
import javax.inject.Inject

class PopularMovieMapper @Inject constructor() :
    RemoteResponseModelMapper<PopularMovieDTO, PopularMovie> {
    override fun mapFromModel(model: PopularMovieDTO): PopularMovie {
        return PopularMovie(
            id = model.id,
            title = model.title,
            description = model.overview,
            image = model.posterPath?.let { "${BuildConfig.BASE_IMAGE_URL}${ImageSizes.ORIGINAL}${model.posterPath}" },
        )
    }
}