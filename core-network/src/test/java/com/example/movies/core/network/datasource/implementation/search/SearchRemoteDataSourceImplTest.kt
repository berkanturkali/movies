package com.example.movies.core.network.datasource.implementation.search

import com.example.movies.core.network.datasource.abstraction.search.SearchRemoteDataSource
import com.example.movies.core.network.datasource.implementation.BaseDataSourceImplTest
import com.example.movies.core.network.dispatcher.BaseDispatcher

class SearchRemoteDataSourceImplTest:BaseDataSourceImplTest<SearchRemoteDataSource,SearchRemoteDataSourceImpl>() {
    override fun initializeDataSource(): SearchRemoteDataSourceImpl {

    }

    override fun setDispatcher(): BaseDispatcher {

    }

}