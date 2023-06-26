package com.example.movies.core.network.mapper.search.tvshow

import com.example.movies.core.model.search.tvshow.TvShow
import com.example.movies.core.network.mapper.base.RemoteResponseModelMapper
import com.example.movies.core.network.mapper.poster.ImagePathMapper
import com.example.movies.core.network.model.search.tvshow.TvShowDTO
import javax.inject.Inject

class TvShowMapper @Inject constructor(
    private val imagePathMapper: ImagePathMapper
) : RemoteResponseModelMapper<TvShowDTO, TvShow> {
    override fun mapFromModel(model: TvShowDTO): TvShow {
        return TvShow(
            id = model.id,
            name = model.name,
            poster = imagePathMapper.mapPath(model.posterPath)
        )
    }
}