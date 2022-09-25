package com.example.movies.core.common.di

import com.example.movies.core.common.executor.abstraction.ExecutorThread
import com.example.movies.core.common.executor.implementation.ExecutorThreadImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
interface ExecutorThreadModule {

    @get:[Binds Singleton]
    val ExecutorThreadImpl.executorThread: ExecutorThread
}