package com.example.movies.core.network.model.search.collection


import com.example.movies.core.network.model.base.BasePagingResponseDTO
import com.squareup.moshi.Json

data class CollectionsResponseDTO(
    @Json(name = "results")
    val results: List<CollectionDTO>,
) : BasePagingResponseDTO()