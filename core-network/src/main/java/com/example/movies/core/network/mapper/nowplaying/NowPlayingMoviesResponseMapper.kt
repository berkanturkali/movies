package com.example.movies.core.network.mapper.nowplaying

import com.example.movies.core.model.home.NowPlayingMovie
import com.example.movies.core.network.BuildConfig
import com.example.movies.core.network.mapper.base.RemoteResponseModelMapper
import com.example.movies.core.network.model.ImageSizes
import com.example.movies.core.network.model.nowplaying.NowPlayingMovieDTO
import javax.inject.Inject

class NowPlayingMoviesResponseMapper @Inject constructor() :
    RemoteResponseModelMapper<NowPlayingMovieDTO, NowPlayingMovie> {
    override fun mapFromModel(model: NowPlayingMovieDTO): NowPlayingMovie {
        return NowPlayingMovie(
            id = model.id,
            title = model.title,
            description = model.overview,
            image = model.posterPath?.let { "${BuildConfig.BASE_IMAGE_URL}${ImageSizes.ORIGINAL}${model.posterPath}" },
        )
    }
}