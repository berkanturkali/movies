package com.example.movies.core.common.executor.implementation

import com.example.movies.core.common.executor.abstraction.ExecutorThread
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class ExecutorThreadImpl @Inject constructor() : ExecutorThread {
    override val main: CoroutineDispatcher
        get() = Dispatchers.Main
    override val io: CoroutineDispatcher
        get() = Dispatchers.IO
    override val default: CoroutineDispatcher
        get() = Dispatchers.Default
}