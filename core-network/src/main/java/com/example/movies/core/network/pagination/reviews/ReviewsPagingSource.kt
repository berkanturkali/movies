package com.example.movies.core.network.pagination.reviews

import com.example.movies.core.network.datasource.abstraction.movies.MoviesRemoteDataSource
import com.example.movies.core.network.model.review.ReviewDTO
import com.example.movies.core.network.pagination.base.BasePagingSource

class ReviewsPagingSource(
    private val remoteDataSource: MoviesRemoteDataSource,
    private val id: Int,
) : BasePagingSource<ReviewDTO>() {
    override suspend fun apiFunc(page: Int): List<ReviewDTO> {
        return remoteDataSource.fetchReviews(id = id, page = page)
    }
}