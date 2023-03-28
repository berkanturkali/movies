package com.example.movies.core.network.model.search.keyword


import com.example.movies.core.network.model.base.BasePagingResponseDTO
import com.squareup.moshi.Json

data class KeywordsResponseDTO(
    @Json(name = "results")
    val keywords: List<KeywordDTO>,
) : BasePagingResponseDTO()