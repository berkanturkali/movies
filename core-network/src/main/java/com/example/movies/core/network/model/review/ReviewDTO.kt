package com.example.movies.core.network.model.review


import com.example.movies.core.network.model.base.BaseDTO
import com.squareup.moshi.Json

data class ReviewDTO(
    @Json(name = "author")
    val author: String? = null,
    @Json(name = "author_details")
    val authorDetails: AuthorDetailsDTO? = null,
    @Json(name = "content")
    val content: String? = null,
    @Json(name = "created_at")
    val createdAt: String? = null,
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "updated_at")
    val updatedAt: String? = null,
    @Json(name = "url")
    val url: String? = null
) : BaseDTO()