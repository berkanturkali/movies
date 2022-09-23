package com.example.movies.core.common

sealed class Resource<T>(
    val data:T? = null,

) {
}