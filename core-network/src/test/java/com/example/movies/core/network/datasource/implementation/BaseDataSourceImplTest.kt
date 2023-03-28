package com.example.movies.core.network.datasource.implementation

import com.example.movies.core.network.dispatcher.BaseDispatcher
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before

abstract class BaseDataSourceImplTest<D : Any, T : D> {

    protected lateinit var mockWebServer: MockWebServer
    protected lateinit var dataSource: D

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = setDispatcher()
        mockWebServer.start()
        dataSource = initializeDataSource()
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }


    abstract fun initializeDataSource(): T

    abstract fun setDispatcher(): BaseDispatcher
}