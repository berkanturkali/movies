package com.example.movies.core.network.mapper.moviedetails

import com.example.movies.core.model.moviedetails.Reviews
import com.example.movies.core.network.mapper.base.RemoteResponseModelMapper
import com.example.movies.core.network.mapper.review.ReviewMapper
import com.example.movies.core.network.model.review.ReviewsResponseDTO
import javax.inject.Inject

class ReviewsResponseMapper @Inject constructor(
    private val reviewMapper: ReviewMapper
) : RemoteResponseModelMapper<ReviewsResponseDTO, Reviews> {
    override fun mapFromModel(model: ReviewsResponseDTO): Reviews {
        return Reviews(
            reviewCount = model.totalResults,
            reviews = reviewMapper.mapFromModelList(model.results)
        )
    }
}