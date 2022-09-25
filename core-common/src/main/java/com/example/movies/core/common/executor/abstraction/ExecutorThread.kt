package com.example.movies.core.common.executor.abstraction

import kotlinx.coroutines.CoroutineDispatcher

interface ExecutorThread {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
}