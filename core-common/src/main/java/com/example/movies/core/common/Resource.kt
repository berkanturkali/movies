package com.example.movies.core.common

sealed class Resource<T>(
    val data: T? = null,
    val error: UiText? = null,
    val errorCode: Int? = null,
) {
    class Success<T>(data: T? = null) : Resource<T>(data)

    class Error<T>(code: Int? = null, text: UiText, data: T? = null) :
        Resource<T>(data = data, errorCode = code, error = text)

    class Loading<T> : Resource<T>(data = null)
}