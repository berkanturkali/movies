package com.example.movies.core.network.mapper.upcoming

import com.example.movies.core.model.home.UpcomingMovie
import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.mapper.base.RemoteResponseModelMapper
import com.example.movies.core.network.model.ImageSizes
import com.example.movies.core.network.model.upcoming.UpcomingMovieDTO
import javax.inject.Inject

class UpcomingMovieMapper @Inject constructor() :
    RemoteResponseModelMapper<UpcomingMovieDTO, UpcomingMovie> {
    override fun mapFromModel(model: UpcomingMovieDTO): UpcomingMovie {
        return UpcomingMovie(
            id = model.id,
            title = model.title,
            description = model.overview,
            image = model.posterPath?.let { "${BuildConfig.BASE_IMAGE_URL}${ImageSizes.ORIGINAL}${model.posterPath}" },
        )
    }
}