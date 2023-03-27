package com.example.movies.core.network.service.search

import com.example.movies.core.network.service.base.BaseService

interface SearchService : BaseService {

    suspend fun fetchCompanies()

    suspend fun fetchCollections()

    suspend fun fetchKeywords()

    suspend fun fetchMovies()

    suspend fun fetchPeople()

    suspend fun fetchTvShow()

}