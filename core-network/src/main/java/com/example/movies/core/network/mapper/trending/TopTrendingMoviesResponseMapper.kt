package com.example.movies.core.network.mapper.trending

import com.example.movies.core.model.home.TrendingMovie
import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.mapper.base.RemoteResponseModelMapper
import com.example.movies.core.network.model.ImageSizes
import com.example.movies.core.network.model.trending.TrendingDTO
import javax.inject.Inject

class TopTrendingMoviesResponseMapper @Inject constructor() :
    RemoteResponseModelMapper<TrendingDTO, TrendingMovie> {
    override fun mapFromModel(model: TrendingDTO): TrendingMovie {
        return TrendingMovie(
            id = model.id,
            title = model.title,
            description = model.overview,
            image = model.posterPath?.let { "${BuildConfig.BASE_IMAGE_URL}${ImageSizes.ORIGINAL}${model.posterPath}" },
        )
    }
}