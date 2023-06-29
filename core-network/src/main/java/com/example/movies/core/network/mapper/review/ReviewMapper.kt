package com.example.movies.core.network.mapper.review

import com.example.movies.core.model.moviedetails.Review
import com.example.movies.core.network.mapper.base.RemoteResponseModelMapper
import com.example.movies.core.network.mapper.poster.ImagePathMapper
import com.example.movies.core.network.model.review.ReviewDTO
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class ReviewMapper @Inject constructor(
    private val imageMapper: ImagePathMapper
) : RemoteResponseModelMapper<ReviewDTO, Review> {
    override fun mapFromModel(model: ReviewDTO): Review {
        return Review(
            reviewerImage = imageMapper.mapPath(model.authorDetails?.avatarPath),
            reviewerName = model.author,
            review = model.content,
            reviewDate = model.createdAt?.let(::mapReviewDate),
            rating = model.authorDetails?.rating?.toString()
        )
    }

    private fun mapReviewDate(date: String): String? {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        return try {
            val parsedDate = inputFormat.parse(date)
            parsedDate?.let { outputFormat.format(parsedDate) }
        } catch (e: Exception) {
            Timber.e(e)
            null
        }
    }
}