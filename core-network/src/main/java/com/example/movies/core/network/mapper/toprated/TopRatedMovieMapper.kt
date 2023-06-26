package com.example.movies.core.network.mapper.toprated

import com.example.movies.core.model.home.TopRatedMovie
import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.mapper.base.RemoteResponseModelMapper
import com.example.movies.core.network.model.ImageSizes
import com.example.movies.core.network.model.toprated.TopRatedMovieDTO
import javax.inject.Inject

class TopRatedMovieMapper @Inject constructor() :
    RemoteResponseModelMapper<TopRatedMovieDTO, TopRatedMovie> {
    override fun mapFromModel(model: TopRatedMovieDTO): TopRatedMovie {
        return TopRatedMovie(
            id = model.id,
            title = model.title,
            description = model.overview,
            image = model.posterPath?.let { "${BuildConfig.BASE_IMAGE_URL}${ImageSizes.W500.size}${model.posterPath}" },
        )
    }
}