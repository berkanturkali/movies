package com.example.movies.core.common.utils

import com.example.movies.core.common.R
import com.example.movies.core.common.Resource
import com.example.movies.core.common.UiText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow

suspend inline fun <T> Flow<Resource<T>>.collectAndHandleResource(
    crossinline loadingFunction: () -> Unit,
    crossinline successFunction: (T?) -> Unit,
    crossinline errorFunction: (UiText?) -> Unit,
) {
    collectLatest { resource ->
        when (resource) {
            is Resource.Error -> errorFunction(resource.error)
            is Resource.Loading -> loadingFunction()
            is Resource.Success -> successFunction(resource.data)
        }
    }
}