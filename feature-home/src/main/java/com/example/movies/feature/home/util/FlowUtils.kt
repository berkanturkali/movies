package com.example.movies.feature.home.util

import com.example.movies.core.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flowOf

fun <ResourceType, EmissionType> Flow<Resource<ResourceType>>.flatMapMergeThenEmit(
    onSuccessEmission: (Resource<ResourceType>) -> EmissionType,
    onLoadingEmission: () -> EmissionType,
    onErrorEmission: (Resource<ResourceType>) -> EmissionType,
): Flow<EmissionType> {
    return flatMapMerge { resource ->
        when (resource) {
            is Resource.Error -> {
                flowOf(onErrorEmission(resource))
            }
            is Resource.Loading -> {
                flowOf(onLoadingEmission())
            }
            is Resource.Success -> {
                flowOf(onSuccessEmission(resource))

            }
        }
    }
}