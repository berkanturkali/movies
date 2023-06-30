package com.example.movies.core.network.mapper.moviedetails

import com.example.movies.core.model.moviedetails.Recommendation
import com.example.movies.core.network.mapper.ScoreMapper
import com.example.movies.core.network.mapper.base.RemoteResponseModelMapper
import com.example.movies.core.network.mapper.poster.ImagePathMapper
import com.example.movies.core.network.model.moviedetails.RecommendationDTO
import javax.inject.Inject

class RecommendationMapper @Inject constructor(
    private val imagePathMapper: ImagePathMapper,
    private val scoreMapper: ScoreMapper,
) :
    RemoteResponseModelMapper<RecommendationDTO, Recommendation> {
    override fun mapFromModel(model: RecommendationDTO): Recommendation {
        return Recommendation(
            id = model.id,
            name = model.title,
            image = imagePathMapper.mapPath(model.posterPath),
            score = scoreMapper.mapVoteAverageToScore(model.voteAverage)
        )
    }
}