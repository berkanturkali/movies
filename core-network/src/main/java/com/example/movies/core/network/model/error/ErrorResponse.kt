package com.example.movies.core.network.model.error

import com.squareup.moshi.Json

data class ErrorResponse(
    @Json(name = "status_code")
    val statusCode: Int,
    @Json(name = "status_message")
    val message: String,
)